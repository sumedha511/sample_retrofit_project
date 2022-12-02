package com.assignment.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.myapplication.data.ResponseItem
import com.assignment.myapplication.data.ResponseX

class JsonListAdapter(var list: ArrayList<String> ): RecyclerView.Adapter<JsonListAdapter.ItemViewHolder>() {


    inner class ItemViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){

        fun bind(element:String){
            val textView = itemView.findViewById<TextView>(R.id.title)
            textView.text = element
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(list.get(position))
    }

    override fun getItemCount(): Int {
        return  list.size
    }
}