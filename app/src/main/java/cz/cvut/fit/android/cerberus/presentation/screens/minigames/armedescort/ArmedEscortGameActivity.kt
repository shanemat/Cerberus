package cz.cvut.fit.android.cerberus.presentation.screens.minigames.armedescort

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import cz.cvut.fit.android.cerberus.presentation.prototype.SingleFragmentActivity

class ArmedEscortGameActivity() : SingleFragmentActivity() {

    companion object Creator {
        fun newIntent(context: Context): Intent {
            return Intent(context, ArmedEscortGameActivity::class.java)
        }
    }

    override fun createFragment(): Fragment {
        return ArmedEscortGameFragment.newInstance()
    }
}