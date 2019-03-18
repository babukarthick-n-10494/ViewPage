package com.example.viewtypeactivity

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toolbar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity() : AppCompatActivity() ,SendInterface {


    val data1 = ArrayList<Student>()
    lateinit var adapter: MyAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        for (i in 1..10) {
            val student = Student()
            student.roman = "VI"
            student.section = 6
            student.stNo = "" + i
            student.stName = "babu" + i
            student.stclass = "six"
            student.stdob = "" + (i + 1) + "." + (i + 1) + "." + "1999"
            data1.add(student)
        }


        for (i in 1..10) {
            val student = Student()
            student.roman = "VII"
            student.section = 7
            student.stNo = "" + i
            student.stName = "babu" + i
            student.stclass = "seven"
            student.stdob = "" + (i + 1) + "." + (i + 1) + "." + "1999"
            data1.add(student)
        }


        for (i in 1..10) {
            val student = Student()
            student.roman = "VIII"
            student.section = 8
            student.stNo = "" + i
            student.stName = "babu" + i
            student.stclass = "eight"
            student.stdob = "" + (i + 1) + "." + (i + 1) + "." + "1999"
            data1.add(student)
        }


        for (i in 1..10) {
            val student = Student()
            student.roman = "IX"
            student.section = 9
            student.stNo = "" + i
            student.stName = "babu" + i
            student.stclass = "nine"
            student.stdob = "" + (i + 1) + "." + (i + 1) + "." + "1999"
            data1.add(student)
        }


        val student1 = Student()
        student1.roman = "VI"
        student1.section = 6
        student1.stNo = "" + 1
        student1.stName = "babu" + 1
        student1.stclass = "six"
        student1.stdob = "" + (1) + "." + (1) + "." + "1999"
        data1.add(student1)

        for (i in 1..10) {
            val student = Student()
            student.roman = "X"
            student.section = 10
            student.stNo = "" + i
            student.stName = "babu" + i
            student.stclass = "ten"
            student.stdob = "" + (i + 1) + "." + (i + 1) + "." + "1999"
            data1.add(student)
        }


        toolbar.title = "Student List"
        setSupportActionBar(toolbar)

        recycle.layoutManager = LinearLayoutManager(this)
        adapter = MyAdapter(data1, this, this)

        recycle.adapter = adapter




    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item != null) {
            when (item.itemId) {
                R.id.add -> {
                    val add = true
                    val intent = Intent(this@MainActivity, FragmentActivity::class.java)
                    intent.putExtra("boo", add)
                    startActivityForResult(intent, 1)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                val name = data!!.getStringExtra("name")
                val std = data!!.getIntExtra("std", 2)
                val date = data!!.getStringExtra("date")
                val id = data!!.getStringExtra("id")
                val roman = data!!.getStringExtra("roman")
                if (!date.isEmpty() && !id.isEmpty() && !name.isEmpty()) {
                    val student = Student()
                    student.stName = name
                    student.stNo = id
                    student.stdob = date
                    student.section = std
                    student.roman = roman
                    data1.add(student)
                    adapter.notifyDataSetChanged()
                    Collections.sort(data1,
                        Comparator<Student> { student, t1 -> if (student.section > t1.section) 1 else if (student.section < t1.section) -1 else 0 })
                    recycle.scrollToPosition(data1.indexOf(student))
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
            }
        }
        else if(requestCode == 2){
            if (resultCode == Activity.RESULT_OK) {

                val name = data!!.getStringExtra("name")
                val std = data.getIntExtra("std", 2)
                val date = data.getStringExtra("date")
                val id = data.getStringExtra("id")
                val roman = data.getStringExtra("roman")
                val pos = data.getIntExtra("pos", 2)
                adapter.delete(pos)
                if (!date.isEmpty() && !id.isEmpty() && !name.isEmpty()) {
                    val student = Student()
                    student.stName =name
                    student.stNo = id
                    student.stdob  = date
                    student.section = std
                    student.roman = roman
                    data1.add(student)
                    adapter.notifyItemChanged(pos)
                    adapter.notifyDataSetChanged()

                    Collections.sort(data1) { student, t1 ->
                        if (student.section > t1.section) 1 else if (student.section < t1.section) -1 else 0
                    }
                    recycle.scrollToPosition(data1.indexOf(student))
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                val pos = data?.getIntExtra("pos",2)
                if (pos != null) {
                    adapter.delete(pos)
                }
                adapter.notifyDataSetChanged()

            }
        }


    }

    override fun SendData(student: Student, postion: Int) {
        val name = student.stName
        val roman = student.roman
        val dob = student.stdob
        val id = student.stNo
        val store = postion
        val stClass = student.section
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra("name", name)
        intent.putExtra("roman", roman)
        intent.putExtra("id", id)
        intent.putExtra("class", stClass)
        intent.putExtra("pos", postion)
        Log.d("hi", roman)
        intent.putExtra("dob", dob)
        startActivityForResult(intent, 2)
    }

}