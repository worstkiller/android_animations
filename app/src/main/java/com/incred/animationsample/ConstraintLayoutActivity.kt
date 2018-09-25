package com.incred.animationsample

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v4.view.animation.LinearOutSlowInInterpolator
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_constraint_layout.*

/**
 * Created by incred on 25/9/18.
 */
class ConstraintLayoutActivity : AppCompatActivity() {

    lateinit var clMain: ConstraintLayout
    lateinit var constraint1: ConstraintSet
    lateinit var constraint2: ConstraintSet
    var set = false
    lateinit var btbBuy: AppCompatButton

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constraint_layout)
        btbBuy = findViewById<AppCompatButton>(R.id.btnBuy)
        clMain = findViewById<ConstraintLayout>(R.id.clMain)
        initMembers()
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun initMembers() {
        constraint1 = ConstraintSet()
        constraint1.clone(clMain)
        constraint2 = ConstraintSet()
        constraint2.clone(this, R.layout.activity_constraint_layout_2)
        btnBuy.setOnClickListener { addAnimation() }
    }

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    private fun addAnimation() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val transition = ChangeBounds()
            transition.interpolator = OvershootInterpolator()
            TransitionManager.beginDelayedTransition(clMain, transition)
            val constraint = if (set) {
                btnBuy.text = "Buy now"
                constraint1
            } else {
                btnBuy.text = "Buy now (300 Rs.)"
                constraint2
            }
            constraint.applyTo(clMain)
            this.set = !set
        }
    }
}