package dev.matyaqubov.bottomsheetdialog

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class MainActivity : AppCompatActivity() {
    private lateinit var bottomSheet: BottomSheetBehavior<View>
    private lateinit var bottomSheetBehavior: BottomSheetBehavior<View>
    private lateinit var checkBoxCash: CheckBox
    private lateinit var checkBoxCard: CheckBox

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()
        showCardPayment()
    }

    @SuppressLint("ResourceType")
    private fun initViews() {
        var botomsheet = findViewById<View>(R.id.bottomsheet)
        var payment = findViewById<Button>(R.id.btn_payment)
        var pay = findViewById<Button>(R.id.btn_pay)
        bottomSheetBehavior = BottomSheetBehavior.from(botomsheet)

        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
        payment.setOnClickListener {
            if (bottomSheetBehavior.state == BottomSheetBehavior.STATE_HIDDEN) {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_COLLAPSED
            } else {
                bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

            }
        }

        pay.setOnClickListener {
            bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN
            if (checkBoxCard.isChecked){
                Toast.makeText(this, "Card Selected", Toast.LENGTH_SHORT).show()
            }
            if (checkBoxCash.isChecked){
                Toast.makeText(this, "Cash Selected", Toast.LENGTH_SHORT).show()
            }

        }



    }

    private fun showCardPayment() {
        var cash_layout = findViewById<LinearLayout>(R.id.layout_cash)
        var card_layout = findViewById<LinearLayout>(R.id.layout_card)
        checkBoxCash = findViewById(R.id.checkbox_cash)
        checkBoxCard = findViewById(R.id.checkbox_card)

        cash_layout.setOnClickListener {
            if (checkBoxCash.isChecked) {
                checkBoxCash.isChecked = false
            } else {
                checkBoxCash.isChecked = true
                checkBoxCard.isChecked = false
            }
        }
        card_layout.setOnClickListener {
            if (checkBoxCard.isChecked) {
                checkBoxCard.isChecked = false
            } else {
                checkBoxCard.isChecked = true
                checkBoxCash.isChecked = false
            }


        }


    }
}