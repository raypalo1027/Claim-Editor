package com.cspsc411.clameeditor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.loopj.android.http.AsyncHttpClient.log


class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var claimTitleEditText : EditText
    lateinit var dateEditText : EditText
    lateinit var statusTextView : TextView
    lateinit var addClaimButton : Button

    var currentIndex : Int = 0
    var claimList : MutableList<Claim> = mutableListOf()
    lateinit var claimObject : Claim
    lateinit var claimService: ClaimService
    val defaultClaimTitleText : String = ""
    val defaultDateText : String = ""
    val defaultStatusMessage : String = "Waiting for claim"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        claimTitleEditText = findViewById(R.id.claim_title_edit_text)
        dateEditText  = findViewById(R.id.date_edit_text)
        addClaimButton  = findViewById(R.id.add_claim_button)
        statusTextView = findViewById(R.id.status_message_text_view)
        statusTextView.setText(defaultStatusMessage)

        refreshScreen()
        addClaimButton.setOnClickListener(this)
    }

    fun refreshScreen() {
        claimTitleEditText.setText(defaultClaimTitleText)
        dateEditText.setText(defaultDateText)

    }

    /*Pops up message at the bottom of the screen to confirm that the claim as been added*/
     override fun onClick(view : View?) {
        var claimTitle = claimTitleEditText.text.toString()
        var claimDate = dateEditText.text.toString()
        claimObject = Claim(claimTitle, claimDate)
        claimList.add(currentIndex, claimObject)

        log.d("Added Claim", "${claimList[currentIndex].claimTitle}, ${claimList[currentIndex].claimDate}")

        currentIndex = currentIndex + 1
//         claimService.addClaim(claimObject)



        statusTextView.setText("Add another claim")
         Toast.makeText(applicationContext, "Claim added successfully", Toast.LENGTH_SHORT).show()
         refreshScreen()
    }









}

