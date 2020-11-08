package com.example.test


import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.ButtonBarLayout
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_and_version.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import android.widget.TextView





class MainActivity : AppCompatActivity(), AnkoLogger {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        andVersionRecyclerView.layoutManager = LinearLayoutManager(this)
        andVersionRecyclerView.adapter = AndVersionAdapter(items)
        PreferenceManager.setDefaultValues(this, R.xml.fragment_settings, false)
        var defaultSharedPref = PreferenceManager.getDefaultSharedPreferences(this)
        defaultSharedPref.getBoolean(getString(R.string.pref_sound), true)
        var sharedPref = getPreferences(Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putInt("5", 5)
        var userName: String by DelegatesExt.preference(this, PREF_NAME, "John")
        userName = "Justin"
        val button : Button = findViewById(R.id.button1)
        button.setOnClickListener() {
            buttonToSettings()
        }


    }

    companion object {
        const val PREF_NAME = "John"
    }

    //Debut du code du recycler view

    val items = arrayOf(
        AndVersion("Lollipop"),
        AndVersion("Lollipop"),
        AndVersion("Banana"),
        AndVersion("Oreo")
    )


    @SuppressLint("ResourceType")
    fun switchLayout() {
        button1.setOnClickListener {
            setContentView(R.xml.fragment_settings)
        }
    }

    @SuppressLint("ResourceType")
    fun buttonToSettings() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("ALERT")
        builder.setMessage("Vous avez appuyer sur le bouton")
        builder.show()
        setContentView(R.layout.test_layout)
    }



}

