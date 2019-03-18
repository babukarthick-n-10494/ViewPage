package com.example.viewtypeactivity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)
        val ft  = supportFragmentManager.beginTransaction()
        val addlistFragment = AddlistFragment()
        ft.add(R.id.frame, addlistFragment)
        ft.commit()
    }
}
