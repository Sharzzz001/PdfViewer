package com.example.pdfviewer

import android.annotation.SuppressLint
import android.net.Uri
import android.os.Bundle
import android.provider.OpenableColumns
import android.util.Log
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.documentfile.provider.DocumentFile


class Listofpdf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listofpdf)
        val j: Uri? = intent.data;
//        Toast.makeText(this@Listofpdf,j,Toast.LENGTH_SHORT).show()
        Log.d("APath: ", j.toString())

        // important part
        val filenamesToDocumentFile = mutableMapOf<String, DocumentFile>()
        val documentsTree = j?.let { DocumentFile.fromTreeUri(this, it) } ?: return
        val childDocuments = documentsTree.listFiles()
        for (childDocument in childDocuments) {
            childDocuments[0].name?.let {
                filenamesToDocumentFile[it] = childDocument
            }
        }
        var lv = findViewById<ListView>(R.id.ls)
        val your_array_list: MutableList<String> = ArrayList()

        for(key in filenamesToDocumentFile.keys){
            your_array_list.add(key)
        }
        Log.d("Child","Child: $your_array_list")

//        val a = j?.let { getFileName(it) }
//        Log.d("Return Result: ",a.toString())



    }


}