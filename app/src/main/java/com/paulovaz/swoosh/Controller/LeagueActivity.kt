package com.paulovaz.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import com.paulovaz.swoosh.Model.Player
import com.paulovaz.swoosh.R
import com.paulovaz.swoosh.Utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {
    private var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null)
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
    }

    fun leagueNextClicked (view: View) {
        if (player.league.isNotEmpty()) {
            val skillActivity = Intent(this,  SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_PLAYER, player)
            startActivity(skillActivity)
        } else
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
    }

    fun onMensClicked (view: View){
        womensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false
        selectLeague(view as ToggleButton)
    }

    fun onWomensClicked (view: View){
        mensLeagueButton.isChecked = false
        coedLeagueButton.isChecked = false
        selectLeague(view as ToggleButton)
    }

    fun onCoedClicked (view: View){
        womensLeagueButton.isChecked = false
        mensLeagueButton.isChecked = false
        selectLeague(view as ToggleButton)
    }

    private fun selectLeague (toggleButtonView: ToggleButton) {
        player.league = if (toggleButtonView.isChecked) toggleButtonView.text.toString().toLowerCase() else ""
    }
}
