package com.example.test


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_and_version.view.*

class MainActivity : AppCompatActivity(), AnkoLogger {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        info(R.string.app_name)


        //Debut du code du recycler view

        val andVersionArray = arrayOf(AndVersion("Banana"),
            AndVersion("Lollipop"))
        andVersionRecyclerView.adapter = AndVersionAdapter(andVersionArray)
        andVersionRecyclerView.layoutManager = LinearLayoutManager(this)
    }

}



class AndVersionAdapter(val items: Array<AndVersion>) : RecyclerView.Adapter<AndVersionAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view), LayoutContainer {
        override val containerView: View?
            get() = itemView
        fun bindAndVersion(andVersion: AndVersion) {
            with(andVersion) {
                itemView.andVersionTxt.text = "$name"
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndVersionAdapter.ViewHolder {
        fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View {
            return LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)
        }
        val lineView = LayoutInflater.from(parent.context).inflate(R.layout.item_and_version, parent, false)
        return ViewHolder(parent.inflate(R.layout.item_and_version))



    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindAndVersion(items[position])
    }

    override fun getItemCount(): Int = items.size
}


// fin du code recycler view