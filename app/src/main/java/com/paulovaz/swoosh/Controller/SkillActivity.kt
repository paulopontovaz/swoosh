package com.paulovaz.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import com.paulovaz.swoosh.Utilities.*
import com.paulovaz.swoosh.R
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {
    var league: String = ""
    var selectedSkill: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)
        println(league)
    }

    fun onFinishClicked(view: View){
        if (selectedSkill.isNotEmpty()){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_LEAGUE, league)
            finishActivity.putExtra(EXTRA_SKILL, selectedSkill)
            startActivity(finishActivity)
        } else Toast.makeText(this, "Please select a skill level", Toast.LENGTH_SHORT).show()
    }

    fun onBeginnerClicked(view: View){
        ballerSkillButton.isChecked = false
        selectSkill(view as ToggleButton)
    }

    fun onBallerClicked(view: View){
        beginnerSkillButton.isChecked = false
        selectSkill(view as ToggleButton)
    }

    private fun selectSkill (toggleButtonView: ToggleButton) {
        selectedSkill = if (toggleButtonView.isChecked) toggleButtonView.text.toString().toLowerCase() else ""
    }
}
