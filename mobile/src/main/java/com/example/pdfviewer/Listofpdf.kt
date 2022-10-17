package com.example.pdfviewer

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.documentfile.provider.DocumentFile


class Listofpdf : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listofpdf)
        val j: Uri? = intent.data;
        val sendtowatch = findViewById<Button>(R.id.sendtowatch);
//        Toast.makeText(this@Listofpdf,j,Toast.LENGTH_SHORT).show()
        Log.d("APath: ", j.toString())

        // important part
        val filenamesToDocumentFile = mutableMapOf<String, DocumentFile>()
        val filepathsToDocumentFile = mutableMapOf<Uri, DocumentFile>()
        val documentsTree = j?.let { DocumentFile.fromTreeUri(this, it) } ?: return
        val childDocuments = documentsTree.listFiles()
        for (childDocument in childDocuments) {
            childDocument.name?.let {
                filenamesToDocumentFile[it] = childDocument
            }
            childDocument.uri?.let {
                filepathsToDocumentFile[it] = childDocument
            }
        }

        val your_array_list: MutableList<String> = ArrayList()
        val your_path_list: MutableList<Uri> = ArrayList()


        for(key in filenamesToDocumentFile.keys){
//            Log.d("Key name:",key)
            your_array_list.add(key)
        }
        for(path in filepathsToDocumentFile.keys){
//            Log.d("Key name:",key)
            your_path_list.add(path)
        }
        Log.d("path: ",your_path_list.toString())
        Log.d("arr: ",your_array_list.toString())
//        val a = j?.let { getFileName(it) }
//        Log.d("Return Result: ",a.toString())
        val listview = findViewById<ListView>(R.id.ls)
        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, your_array_list)
        listview.adapter = arrayAdapter
        sendtowatch.setOnClickListener{
            for(i in your_path_list){
                Log.d("Child: ", i.toString())
            }
        }

    }

    private fun sendingdata(i: String) {

    }


}
