package com.example.test

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.test_layout.*
import org.jetbrains.anko.AnkoLogger

class ColorFragment : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                setContentView(R.layout.test_layout)

        buttonNoir.setOnClickListener {
            view.setBackgroundResource(R.color.black)
        }



    }
}