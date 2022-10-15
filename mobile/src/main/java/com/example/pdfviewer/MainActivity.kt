package com.example.pdfviewer

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.DocumentsContract
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val browsebtn = findViewById<Button>(R.id.openfilemgr);
        browsebtn.setOnClickListener{
            opendirectory();
        }

    }

 fun opendirectory() {
     // Choose a directory using the system's file picker.
     val intent = Intent(Intent.ACTION_OPEN_DOCUMENT_TREE).apply {
         // Optionally, specify a URI for the directory that should be opened in
         // the system file picker when it loads
     }

     startActivityForResult(intent, 8000)

    }

    override fun onActivityResult(
        requestCode: Int, resultCode: Int, resultData: Intent?) {
        super.onActivityResult(requestCode, resultCode, resultData)
        if (requestCode == 8000
            && resultCode == Activity.RESULT_OK) {
            // The result data contains a URI for the document or directory that
            // the user selected.
            resultData?.data?.also { uri ->
                // Perform operations on the document using its URI.
            val j = Intent(this@MainActivity,Listofpdf::class.java);
                j.putExtra("URI", uri);
                startActivity(j)
            }
        }
    }

}
