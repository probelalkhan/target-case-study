package com.target.targetcasestudy.ui.deals

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.network.Resource
import com.target.targetcasestudy.databinding.FragmentDealListBinding
import com.target.targetcasestudy.ui.dealitem.DealItemFragment
import com.target.targetcasestudy.ui.utils.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DealListFragment : Fragment(R.layout.fragment_deal_list) {

    private lateinit var binding: FragmentDealListBinding
    private val viewModel: DealListFragmentViewModel by viewModels()

    private val adapter by lazy { DealItemAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDealListBinding.bind(view)

        binding.recyclerView.setUpRecyclerView(requireContext(), adapter)
        { itemView, item, position ->
            findNavController().navigate(
                R.id.dealItemFragment,
                bundleOf(DealItemFragment.KEY_PRODUCT_ID to item.id)
            )
        }

        viewModel.productListResponse.observe(viewLifecycleOwner) { resource ->
            when (resource) {
                Resource.Loading -> binding.progress.show()
                is Resource.Failure -> handleApiError(resource, binding.progress)
                is Resource.Success -> {
                    binding.progress.hide()
                    adapter.items = resource.value.products
                }
            }
        }
    }
}
