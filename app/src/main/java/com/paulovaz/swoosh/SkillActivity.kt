package com.paulovaz.swoosh

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SkillActivity : BaseActivity() {
    var league: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)
    }
}
