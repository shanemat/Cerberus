package cz.cvut.fit.android.cerberus.presentation.minigames.quartermaster

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.cvut.fit.android.cerberus.R

class QuartermasterGameFragment internal constructor() : Fragment() {

    companion object Creator {
        fun newInstance(): QuartermasterGameFragment {
            return QuartermasterGameFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_games_quartermaster, container, false)
    }
}