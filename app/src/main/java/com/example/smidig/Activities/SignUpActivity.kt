package com.example.smidig.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.smidig.R
import com.example.smidig.database.Login
import com.example.smidig.database.LoginDao
import com.example.smidig.database.MultiDatabase


class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        supportActionBar?.hide()

        var loginDAO : LoginDao = MultiDatabase.get(this).getLDao()

        //Adds your new user to the database
        var submit = findViewById<ImageView>(R.id.buttonBG)
        submit.setOnClickListener {

            val username = findViewById<EditText>(R.id.emailEditText)
            val password = findViewById<EditText>(R.id.passwordEditText)

            var user : Login = Login(0, username.text.toString(), password.text.toString())
            loginDAO.addLogin(user)

            println(user)

            val i = Intent(this, SigninActivity::class.java)
            startActivity(i)
        }

        //Makes toast when clicking info button
        var infoBtn = findViewById<ImageView>(R.id.infoIcon)
        infoBtn.setOnClickListener{
            val popUp = PopupMenu(this, infoBtn)
            val popUpToast = Toast.makeText(applicationContext,
                "Registrer deg her for å kunne logge inn \n",
                Toast.LENGTH_SHORT).show()
        }

        //Takes you to the signin page
        val goBackBtn = findViewById<ImageView>(R.id.backIcon)
        goBackBtn.setOnClickListener {
            val i = Intent(this, SigninActivity::class.java)
            startActivity(i)
        }

    }
}