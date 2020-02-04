package com.example.firedbtestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_db_save.*

class DbSave : AppCompatActivity() {

    var db = FirebaseDatabase.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_db_save)
        bindListeners()
    }
    fun bindListeners(){
        save.setOnClickListener {
            val name = Name.text.toString()
            val add = Address.text.toString()

            val data : Man = Man(name,add)

            db.child("User").setValue(data).addOnSuccessListener {
                Toast.makeText(this,"Yooo hoise man",Toast.LENGTH_SHORT).show()
            }
        }
    }
}
