package cz.cvut.fit.android.cerberus.presentation.screens.minigames.archaeologist

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.cvut.fit.android.cerberus.R

class ArchaeologistGameFragment internal constructor() : Fragment() {

    companion object Creator {
        fun newInstance(): ArchaeologistGameFragment {
            return ArchaeologistGameFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_games_archaeologist, container, false)
    }
}