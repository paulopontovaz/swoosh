package com.paulovaz.swoosh.Controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.ToggleButton
import com.paulovaz.swoosh.Utilities.EXTRA_LEAGUE
import com.paulovaz.swoosh.R
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {
    var selectedLeague: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun leagueNextClicked (view: View) {
        if (selectedLeague.isNotEmpty()) {
            val skillActivity = Intent(this,  SkillActivity::class.java)
            skillActivity.putExtra(EXTRA_LEAGUE, selectedLeague)
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
        selectedLeague = if (toggleButtonView.isChecked) toggleButtonView.text.toString().toLowerCase() else ""
    }
}
