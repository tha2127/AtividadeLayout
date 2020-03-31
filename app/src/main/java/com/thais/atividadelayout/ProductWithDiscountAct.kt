package com.thais.atividadelayout

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class ProductWithDiscountAct : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btCalcultePriceProduct.setOnClickListener {
            if (textNome.text?.isNotEmpty()!! && textPreco.text?.isNotEmpty()!!) {
                val priceProduct = textPreco.editableText.toString().toDouble()
                val discount = textDesconto.editableText.toString().toDoubleOrNull()
                val totalAmountPayable = discount?.let { priceProduct * (100 - discount) / 100 } ?: priceProduct
                Toast.makeText(this, totalAmountPayable.toString(), Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, getString(R.string.fill_the_fields_correctly), Toast.LENGTH_LONG).show()
            }
        }
    }
}
