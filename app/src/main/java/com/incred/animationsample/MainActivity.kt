package com.incred.animationsample

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<AppCompatButton>(R.id.btnConstraint).setOnClickListener { startConstraintFragment() }
    }

    private fun startConstraintFragment() {
        startActivity(Intent(this@MainActivity,ConstraintLayoutActivity::class.java))
    }
}
