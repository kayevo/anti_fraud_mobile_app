package com.kayevo.antifraudapp.ui.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kayevo.antifraudapp.databinding.ActivityPaymentBinding

class PaymentMethodActivity : AppCompatActivity() {
    private lateinit var view: ActivityPaymentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityPaymentBinding.inflate(layoutInflater)
        setContentView(view.root)
        setListeners()
    }

    private fun setListeners() {
        with(view) {
            btnCreditCardPayment.setOnClickListener {
                goToCreditCardPayment()
            }
        }
    }

    private fun goToCreditCardPayment() {
        val intent = Intent(this, CreditCardPaymentActivity::class.java)
        startActivity(intent)
    }

    private fun goToBankTransferPayment() {
        val intent = Intent(this, BankTransferPaymentActivity::class.java)
        startActivity(intent)
    }
}