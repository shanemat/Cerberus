package cz.cvut.fit.android.cerberus.presentation.screens.minigames.paramedic

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import cz.cvut.fit.android.cerberus.presentation.prototype.SingleFragmentActivity

class ParamedicGameActivity() : SingleFragmentActivity() {

    companion object Creator {
        fun newIntent(context: Context): Intent {
            return Intent(context, ParamedicGameActivity::class.java)
        }
    }

    override fun createFragment(): Fragment {
        return ParamedicGameFragment.newInstance()
    }
}