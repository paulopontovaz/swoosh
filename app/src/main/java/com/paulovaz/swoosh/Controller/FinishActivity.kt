package com.paulovaz.swoosh.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.paulovaz.swoosh.Model.Player
import com.paulovaz.swoosh.R
import com.paulovaz.swoosh.Utilities.*
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {
    private lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        player = intent.getParcelableExtra(EXTRA_PLAYER)

        searchLeaguesText.text = "Looking for a ${player.league} ${player.skill} league near you..."
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null)
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
    }
}
