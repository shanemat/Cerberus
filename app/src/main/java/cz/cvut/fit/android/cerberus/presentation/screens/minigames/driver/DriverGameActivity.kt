package cz.cvut.fit.android.cerberus.presentation.screens.minigames.driver

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import cz.cvut.fit.android.cerberus.presentation.prototype.SingleFragmentActivity

class DriverGameActivity() : SingleFragmentActivity() {

    companion object Creator {
        fun newIntent(context: Context): Intent {
            return Intent(context, DriverGameActivity::class.java)
        }
    }

    override fun createFragment(): Fragment {
        return DriverGameFragment.newInstance()
    }
}