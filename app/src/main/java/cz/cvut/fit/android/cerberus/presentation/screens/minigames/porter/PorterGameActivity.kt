package cz.cvut.fit.android.cerberus.presentation.screens.minigames.porter

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import cz.cvut.fit.android.cerberus.presentation.prototype.SingleFragmentActivity

class PorterGameActivity() : SingleFragmentActivity() {

    companion object Creator {
        fun newIntent(context: Context): Intent {
            return Intent(context, PorterGameActivity::class.java)
        }
    }

    override fun createFragment(): Fragment {
        return PorterGameFragment.newInstance()
    }
}