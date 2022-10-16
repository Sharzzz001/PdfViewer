package com.example.pdfviewer

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
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
        val your_array_list: MutableList<String> = ArrayList()

        for(key in filenamesToDocumentFile.keys){
//            Log.d("Key name:",key)
            your_array_list.add(key)
        }

        val mylist= arrayOf(your_array_list);
//        Log.d("mylist :", mylist.toString())
//        Log.d("Child","Child: $mylist")
        val finarr: MutableList<String> = ArrayList()
        for(i in mylist){
            val text = i.toString().replace("[", "").replace("]", "");
//            Log.d("This is text: ", text)
            finarr.add(text)
        }

//        val a = j?.let { getFileName(it) }
//        Log.d("Return Result: ",a.toString())
        val listview = findViewById<ListView>(R.id.ls)
        val arrayAdapter: ArrayAdapter<*>
        arrayAdapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1, finarr)
        listview.adapter = arrayAdapter

    }


}
