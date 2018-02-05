package cz.cvut.fit.android.cerberus.presentation.minigames.poacher

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import cz.cvut.fit.android.cerberus.presentation.SingleFragmentActivity

class PoacherGameActivity() : SingleFragmentActivity() {

    companion object Creator {
        fun newIntent(context: Context): Intent {
            return Intent(context, PoacherGameActivity::class.java)
        }
    }

    override fun createFragment(): Fragment {
        return PoacherGameFragment.newInstance()
    }
}