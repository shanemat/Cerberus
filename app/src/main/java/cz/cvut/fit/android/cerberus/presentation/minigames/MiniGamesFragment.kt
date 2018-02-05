package cz.cvut.fit.android.cerberus.presentation.minigames

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.presentation.minigames.armedescort.ArmedEscortGameActivity
import cz.cvut.fit.android.cerberus.presentation.minigames.driver.DriverGameActivity
import cz.cvut.fit.android.cerberus.presentation.minigames.poacher.PoacherGameActivity
import cz.cvut.fit.android.cerberus.presentation.minigames.porter.PorterGameActivity
import kotlinx.android.synthetic.main.fp_games_armed_escort.*
import kotlinx.android.synthetic.main.fp_games_driver.*
import kotlinx.android.synthetic.main.fp_games_poacher.*
import kotlinx.android.synthetic.main.fp_games_porter.*

class MiniGamesFragment internal constructor() : Fragment() {

    companion object Creator {
        fun newInstance(): MiniGamesFragment {
            return MiniGamesFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_games, container, false)
    }

    override fun onStart() {
        super.onStart()

        setUp()
    }

    private fun setUp() {
        setUpPoacherButton()
        setUpPorterButton()
        setUpDriverButton()
        setUpArmedEscortButton()
    }

    private fun setUpPoacherButton() {
        gamesPoacherButton.setOnClickListener {
            val poacherIntent = PoacherGameActivity.newIntent(this.activity!!)
            startActivity(poacherIntent)
        }
    }

    private fun setUpPorterButton() {
        gamesPorterButton.setOnClickListener {
            val porterIntent = PorterGameActivity.newIntent(this.activity!!)
            startActivity(porterIntent)
        }
    }

    private fun setUpDriverButton() {
        gamesDriverButton.setOnClickListener {
            val driverIntent = DriverGameActivity.newIntent(this.activity!!)
            startActivity(driverIntent)
        }
    }

    private fun setUpArmedEscortButton() {
        gamesArmedEscortButton.setOnClickListener {
            val armedEscortIntent = ArmedEscortGameActivity.newIntent(this.activity!!)
            startActivity(armedEscortIntent)
        }
    }
}