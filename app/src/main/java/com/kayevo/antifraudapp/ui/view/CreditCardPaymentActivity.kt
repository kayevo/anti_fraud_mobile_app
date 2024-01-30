package com.kayevo.antifraudapp.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kayevo.antifraudapp.databinding.ActivityCreditCardPaymentBinding
import com.kayevo.antifraudapp.ui.viewmodel.CreditCardPaymentViewModel

class CreditCardPaymentActivity : AppCompatActivity() {
    private lateinit var view: ActivityCreditCardPaymentBinding
    private var viewModel = CreditCardPaymentViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityCreditCardPaymentBinding.inflate(layoutInflater)
        setContentView(view.root)
        setListeners()
        setObservers()
    }

    private fun setListeners() {
        with(view) {
            btnPay.setOnClickListener {
                // TODO remove mock value
                viewModel.verifyPaymentFraud(10.0)
            }
        }
    }

    private fun setObservers() {
        viewModel.paymentIsFraud.observe(this) { result ->
            when (result) {
                true -> {
                    showMessage("We cannot complete your payment, ask for support on support@payment.com")
                }
                else -> {
                    viewModel.pay(10.0) // TODO remove mock value
                }
            }
        }
        viewModel.paymentAccepted.observe(this) { result ->
            when (result) {
                true -> {
                    showMessage("Your value was payed successfully")
                }
                else -> {
                    showMessage("Payment was not accepted, verify the credit card information or contact your credit card issuer.")
                }
            }
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}