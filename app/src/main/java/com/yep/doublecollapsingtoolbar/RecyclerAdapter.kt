package com.yep.doublecollapsingtoolbar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.view_recycler_item, parent, false)
        )
    }

    override fun getItemCount(): Int = 2000

    override fun onBindViewHolder(viewHolder: ViewHolder, p1: Int) {
        (viewHolder.itemView as TextView).text = "Item " + p1;
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)
}
