package com.example.students_reg

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSave.setOnClickListener( View.OnClickListener {
            val db = FirebaseFirestore.getInstance()

            val data = hashMapOf(
                "fullname" to etFullname.text.toString(),
                "email" to etEmail.text.toString(),
                "regno" to etRegNo.text.toString(),
                "course" to etCourse.text.toString()
            )

            db.collection("bioinfo").add(data)
                .addOnSuccessListener {
                    Log.d("SaveStudent", "Success")
                }
                .addOnFailureListener{
                    Log.d("SaveStudent", "Failed")
                }
        })
    }
}
