package com.target.targetcasestudy.ui.dealitem

import android.graphics.Paint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.models.DealItemResponse
import com.target.targetcasestudy.data.network.Resource
import com.target.targetcasestudy.databinding.FragmentDealItemBinding
import com.target.targetcasestudy.ui.utils.*
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DealItemFragment : Fragment(R.layout.fragment_deal_item) {

    private lateinit var binding: FragmentDealItemBinding
    private val viewModel: DealItemFragmentViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDealItemBinding.bind(view)
        viewModel.getDealItem(getDealId())

        viewModel.dealItem.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                Resource.Loading -> binding.progress.show()
                is Resource.Failure -> handleApiError(resource, binding.progress)
                is Resource.Success -> {
                    binding.progress.hide()
                    updateUI(resource.value)
                }
            }
        }
    }

    private fun updateUI(dealItem: DealItemResponse): Unit = with(binding) {
        imageViewDeal.loadImage(dealItem.image_url)
        textViewSalePrice.text =
            dealItem.sale_price?.display_string ?: dealItem.regular_price.display_string
        textViewRegPrice.text = getString(R.string.reg_price, dealItem.regular_price.display_string)
        textViewTitle.text = dealItem.title
        textViewDesc.text = dealItem.description
        textViewRegPrice.paintFlags = textViewRegPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
    }

    private fun getDealId(): Int {
        return arguments?.getInt(KEY_PRODUCT_ID)
            ?: throw IllegalArgumentException("Deal Id Not Provided")
    }

    companion object {
        const val KEY_PRODUCT_ID = "key_product_id"
    }
}
