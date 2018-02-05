package cz.cvut.fit.android.cerberus.presentation.minigames.bombexpert

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.cvut.fit.android.cerberus.R

class BombExpertGameFragment internal constructor() : Fragment() {

    companion object Creator {
        fun newInstance(): BombExpertGameFragment {
            return BombExpertGameFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_games_bomb_expert, container, false)
    }
}