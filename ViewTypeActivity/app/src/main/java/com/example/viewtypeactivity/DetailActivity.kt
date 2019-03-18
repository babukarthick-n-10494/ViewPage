package com.example.viewtypeactivity

import android.app.Activity
import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle = intent.extras
        val name = bundle!!.getString("name")
        val dob = bundle.getString("dob")
        val roman = bundle.getString("roman")
        val id = bundle.getString("id")
        val stclass = bundle.getInt("class")
        val pos = bundle.getInt("pos")

        sname.text = name
        sdob.text = dob
        sroman.text = roman

        edit.setOnClickListener(View.OnClickListener {
            val update = false
            val intent = Intent(this@DetailActivity, FragmentActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("id", id)
            intent.putExtra("boolean", update)
            intent.putExtra("pos", pos)
            startActivityForResult(intent, 3)

        })
        delete.setOnClickListener(
            View.OnClickListener {
                val alert = AlertDialog.Builder(this)
                alert.setTitle("Are you want to Remove?")
                alert.setPositiveButton("Yes"){ dialogInterface, i ->
                    val intent = Intent(this@DetailActivity,FragmentActivity::class.java)
                    intent.putExtra("pos",pos)
                    setResult(Activity.RESULT_CANCELED,intent)
                    finish()
                }
                alert.setNegativeButton("No"){dialogInterface, i ->
                    dialogInterface.cancel()

                }
                val dialog = alert.create()
                dialog.show()
            })









    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

            if (requestCode == 3) {
                if (resultCode == Activity.RESULT_OK) {
                    val name = data!!.getStringExtra("name")
                    val std = data.getIntExtra("std", 2)
                    val date = data.getStringExtra("date")
                    val id = data.getStringExtra("id")
                    val roman = data.getStringExtra("roman")
                    val pos = data.getIntExtra("pos", 2)
                    val intent = Intent(this@DetailActivity, MainActivity::class.java)
                    intent.putExtra("name", name)
                    intent.putExtra("id", id)
                    intent.putExtra("date", date)
                    intent.putExtra("std", std)
                    intent.putExtra("roman", roman)
                    intent.putExtra("pos", pos)
                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }
                if (resultCode == Activity.RESULT_CANCELED) {

                }
            }
    }
}
