package cz.cvut.fit.android.cerberus.presentation.minigames.porter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.cvut.fit.android.cerberus.R

class PorterGameFragment internal constructor() : Fragment() {

    companion object Creator {
        fun newInstance(): PorterGameFragment {
            return PorterGameFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_porter, container, false)
    }
}