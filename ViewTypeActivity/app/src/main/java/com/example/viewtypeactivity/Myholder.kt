package com.example.viewtypeactivity

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import kotlinx.android.synthetic.main.list.view.*

class Myholder(itemView : View, val sendInterface: SendInterface) : RecyclerView.ViewHolder(itemView) {
    val relativeLayout = itemView.findViewById<RelativeLayout>(R.id.relative)
    val textView = itemView.findViewById<TextView>(R.id.roman)
    val imageMenu = itemView.findViewById<ImageView>(R.id.menu)
    fun setData(student: Student){
        itemView.num.text = student.stNo
        itemView.str.text = student.stName
        itemView.doob.text = student.stdob
        itemView.setOnClickListener(View.OnClickListener {
            sendInterface.SendData(student,adapterPosition)
        })



    }
}