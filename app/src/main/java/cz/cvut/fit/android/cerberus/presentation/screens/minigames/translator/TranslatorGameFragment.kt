package cz.cvut.fit.android.cerberus.presentation.screens.minigames.translator

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.cvut.fit.android.cerberus.R

class TranslatorGameFragment internal constructor() : Fragment() {

    companion object Creator {
        fun newInstance(): TranslatorGameFragment {
            return TranslatorGameFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_games_translator, container, false)
    }
}