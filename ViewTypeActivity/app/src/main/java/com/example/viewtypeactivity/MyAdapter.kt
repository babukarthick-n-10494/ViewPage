package com.example.viewtypeactivity

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.PopupMenu
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import android.util.Log
import java.util.*


class MyAdapter(val data:ArrayList<Student>,val context : Context,val sendInterface: SendInterface) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val six = 0;
    val seven = 1;
    val eight = 2;
    val nine = 3;
    val ten = 4;


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
        var view  = LayoutInflater.from(context).inflate(R.layout.list,p0,false)
        when(p1){
            0 -> return  Myholder(view,sendInterface)
            1 -> return Myholder(view,sendInterface)
            2 -> return Myholder(view,sendInterface)
            3 -> return Myholder(view,sendInterface)
            else ->{
                var view1 = LayoutInflater.from(context).inflate(R.layout.tenth,p0,false)
               return TenthHolder(view1,sendInterface)
            }

        }



    }

    fun delete(position: Int){
        data.removeAt(position)
       notifyDataSetChanged()
    }


    override fun getItemCount(): Int {
       return data.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, pos: Int) {
//        when(viewHolder)
//        {
//            is Myholder ->
//            {
//                data[pos].let { student ->
//                    when(student.section)
//                    {
//                        6 ->
//                        {
//                            val myholder = viewHolder
//
//                            myholder.setData(student)
//                            myholder.relativeLayout.setBackgroundColor(Color.parseColor("#FFCCCC"))
//                            myholder.textView.text = "VI"
//                            myholder.imageMenu.setOnClickListener(View.OnClickListener {
//                                Log.d("m","y")
//                                val popup = PopupMenu(context,myholder.imageMenu)
//                                popup.inflate(R.menu.popup)
//
//                                popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
//                                    when (item.itemId) {
//                                        R.id.promote-> {
//                                            student.section = student.section+1
//                                            Log.d("hi","baby karthick")
////                            notifyDataSetChanged()
////                            Collections.sort(data,
////                                Comparator<Student> { student, t1 ->
////                                    if (student.section > t1.section)
////                                        1
////                                    else if (student.section < t1.section)
////                                        -1
////                                    else 0 })
//                                        }
//                                    }
//                                    false
//                                })
//                                popup.show()
//
//
//                            })
//
//
//                        }
//
//                        7 ->
//                        {
//
//                        }
//                    }
//                    viewHolder.textView.setText("")
//                }
//            }
//
//            is TenthHolder ->
//            {
//
//            }
//        }
        if(getItemViewType(pos)==0){
             val myholder = viewHolder as Myholder
             val student  = data.get(pos)

            myholder.setData(student)
            myholder.relativeLayout.setBackgroundColor(Color.parseColor("#FFCCCC"))
            myholder.textView.text = "VI"
            myholder.imageMenu.setOnClickListener(View.OnClickListener {
            Log.d("m","y")
                val popup = PopupMenu(context,myholder.imageMenu)
                popup.inflate(R.menu.popup)

                popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.promote-> {
                            student.section = student.section+1
                            Log.d("hi","baby karthick")
                            notifyDataSetChanged()
                            Collections.sort(data,
                                Comparator<Student> { student, t1 ->
                                    if (student.section > t1.section)
                                        1
                                    else if (student.section < t1.section)
                                        -1
                                    else 0 })
                        }
                    }
                    false
                })
                popup.show()


            })


        }
        else if(getItemViewType(pos)==1){
            val myholder = viewHolder as Myholder
            val student = data.get(pos)
            myholder.setData(student)
            Log.d("hi","babuka")
            myholder.relativeLayout.setBackgroundColor(Color.parseColor("#ffffb3"))
            myholder.textView.text = "VII"
            myholder.imageMenu.setOnClickListener(View.OnClickListener {

                val popup = PopupMenu(context,myholder.imageMenu)
                popup.inflate(R.menu.popup)

                popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.promote-> {
                            student.section = student.section+1
                            notifyDataSetChanged()
                            Collections.sort(data,
                                Comparator<Student> { student, t1 ->
                                    if (student.section > t1.section) 1 else if (student.section < t1.section) -1 else 0 })
                        }
                    }
                    false
                })
                popup.show()


            })

        }
        else if(getItemViewType(pos)==2){
            val myholder = viewHolder as Myholder
            val student  = data.get(pos)
            myholder.setData(student)
            myholder.relativeLayout.setBackgroundColor(Color.parseColor("#ccffff"))
            myholder.textView.text = "VIII"
            myholder.imageMenu.setOnClickListener(View.OnClickListener {

                val popup = PopupMenu(context,myholder.imageMenu)
                popup.inflate(R.menu.popup)

                popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.promote-> {
                            student.section = student.section+1
                            notifyDataSetChanged()
                            Collections.sort(data,
                                Comparator<Student> { student, t1 ->
                                    if (student.section > t1.section) 1 else if (student.section < t1.section) -1 else 0 })
                        }
                    }
                    false
                })
                popup.show()


            })

        }
        else if(getItemViewType(pos)==3){
            val myholder = viewHolder as Myholder
            val student  = data.get(pos)
            myholder.setData(student)
            myholder.relativeLayout.setBackgroundColor(Color.parseColor("#ccffcc"))
            myholder.textView.text = "IX"
            myholder.imageMenu.setOnClickListener(View.OnClickListener {

                val popup = PopupMenu(context,myholder.imageMenu)
                popup.inflate(R.menu.popup)

                popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item ->
                    when (item.itemId) {
                        R.id.promote-> {
                          student.section = student.section+1
                            notifyDataSetChanged()
                            Collections.sort(data,
                                Comparator<Student> { student, t1 ->
                                    if (student.section > t1.section) 1 else if (student.section < t1.section) -1 else 0 })
                        }
                    }
                    false
                })
                popup.show()


            })

        }
        else{
            val tenthHolder = viewHolder as TenthHolder
            val list  = data.get(pos)
            tenthHolder.setData(list)
           tenthHolder.relativeLayout.setBackgroundColor(Color.parseColor("#FFD9B3"))
           tenthHolder.textView.text = "X"
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(data.get(position).section == 6){
            return six;
        }
        else if(data.get(position).section == 7){
            Log.d("hi","babuka")
            return seven
        }
        else if(data.get(position).section == 8){
            return eight
        }
        else if(data.get(position).section == 9){
            return nine;
        }
        else{
            return ten
        }
    }
}