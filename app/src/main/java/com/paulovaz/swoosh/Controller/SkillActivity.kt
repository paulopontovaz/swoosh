package com.paulovaz.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import com.paulovaz.swoosh.Model.Player
import com.paulovaz.swoosh.Utilities.*
import com.paulovaz.swoosh.R
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : BaseActivity() {
    private lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)
        println(player.league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null)
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
    }

    fun onFinishClicked(view: View){
        if (player.skill.isNotEmpty()){
            val finishActivity = Intent(this, FinishActivity::class.java)
            finishActivity.putExtra(EXTRA_PLAYER, player)
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
        player.skill = if (toggleButtonView.isChecked) toggleButtonView.text.toString().toLowerCase() else ""
    }
}
