package cz.cvut.fit.android.cerberus.presentation.story

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.cvut.fit.android.cerberus.R

class StoryFragment internal constructor() : Fragment() {

    companion object Creator {
        fun newInstance(): StoryFragment {
            return StoryFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_story, container, false)
    }
}