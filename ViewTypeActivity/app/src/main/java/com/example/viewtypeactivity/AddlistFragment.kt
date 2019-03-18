package com.example.viewtypeactivity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_addlist.*

class AddlistFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view  = inflater.inflate(R.layout.fragment_addlist,container,false)
        return view
    }


    fun list(){
        val adapter  =ArrayAdapter<Int>(activity,android.R.layout.simple_spinner_item)
        adapter.add(6)
        adapter.add(7)
        adapter.add(8)
        adapter.add(9)
        adapter.add(10)
        std.adapter  =adapter
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list()
        val mainBundle  = activity?.intent?.extras
        val add  = mainBundle?.getBoolean("boo")


        val detailBundle = activity!!.intent.extras
        val update = detailBundle?.getBoolean("boolean")
        val name = detailBundle?.getString("name")
        val id = detailBundle?.getString("id")
        var pos = detailBundle?.getInt("pos")

        if(update == false) {
            sname.setText(name)
            sid.setText(id)
            ok.setOnClickListener(View.OnClickListener {

                val student = onClick()

                val intent = Intent(activity,DetailActivity::class.java)
                intent.putExtra("sender", "FragementAlert")
                intent.putExtra("name", student.stName)
                intent.putExtra("id", student.stNo)
                intent.putExtra("date", student.stdob)
                intent.putExtra("std", student.section)
                intent.putExtra("roman", student.roman)
                    intent.putExtra("pos", pos)

                if(!student.stName.isEmpty() && !student.stNo.isEmpty()){
                    activity!!.setResult(Activity.RESULT_OK, intent)
                    activity!!.supportFragmentManager.beginTransaction().remove(this@AddlistFragment).commit()
                    activity!!.finish()
                }
                else {
                    Toast.makeText(activity, "please fill the name and id", Toast.LENGTH_SHORT).show() }
            })

            cancel.setOnClickListener(View.OnClickListener {
               cancel()
            })
        }
        else if(add  == true){
            ok.setOnClickListener(View.OnClickListener {

                val student = onClick()

                val intent = Intent(activity,MainActivity::class.java)
                intent.putExtra("sender", "FragementAlert")
                intent.putExtra("name", student.stName)
                intent.putExtra("id", student.stNo)
                intent.putExtra("date", student.stdob)
                intent.putExtra("std", student.section)
                intent.putExtra("roman", student.roman)

                if(!student.stName.isEmpty() && !student.stNo.isEmpty()){
                    activity!!.setResult(Activity.RESULT_OK, intent)
                    activity!!.supportFragmentManager.beginTransaction().remove(this@AddlistFragment).commit()
                    activity!!.finish()
                }
                else {
                    Toast.makeText(activity, "please fill the name and id", Toast.LENGTH_SHORT).show() }
            })
            cancel.setOnClickListener(View.OnClickListener {
                cancel()
            })
        }
    }


    fun onClick(): Student{
        val sstd  = std.selectedItem as Int
        val sname = sname.text.toString()
        val sid = sid.text.toString()

        val day = dob.dayOfMonth
        val month  = dob.month+1
        val year = dob.year
        val date = "" + day + "." + month + "." + year

        var roman = ""
        when (sstd) {
            6 -> roman = "VI"
            7 -> roman = "VII"
            8 -> roman = "VIII"
            9 -> roman = "IX"
            else -> roman = "X"
        }

        val student = Student()
        student.section = sstd
        student.roman = roman
        student.stdob = date
        student.stNo = sid
        student.stName = sname

        return student
    }

    fun cancel():Unit{
        activity!!.setResult(Activity.RESULT_CANCELED)
        activity!!.supportFragmentManager.beginTransaction().remove(this@AddlistFragment).commit()
        activity!!.finish()
    }

}
