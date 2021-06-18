package com.target.targetcasestudy.ui.payment

import android.os.Bundle
import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.DialogFragment
import com.target.targetcasestudy.R
import com.target.targetcasestudy.data.validateCreditCard
import com.target.targetcasestudy.databinding.DialogPaymentBinding
import com.target.targetcasestudy.ui.utils.enabled

/**
 * Dialog that displays a minimal credit card entry form.
 *
 * Your task here is to enable the "submit" button when the credit card number is valid and
 * disable the button when the credit card number is not valid.
 *
 * You do not need to input any of your actual credit card information. See `Validators.kt` for
 * info to help you get fake credit card numbers.
 *
 * You do not need to make any changes to the layout of this screen (though you are welcome to do
 * so if you wish).
 */
class PaymentDialogFragment : DialogFragment(R.layout.dialog_payment) {

    private lateinit var binding: DialogPaymentBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DialogPaymentBinding.bind(view)
        binding.cancel.setOnClickListener { dismiss() }
        binding.submit.setOnClickListener { dismiss() }
        binding.submit.enabled(false)
        binding.cardNumber.addTextChangedListener {
            binding.submit.enabled(validateCreditCard(it.toString()))
        }
    }
}