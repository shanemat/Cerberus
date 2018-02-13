package cz.cvut.fit.android.cerberus.presentation.screens.minigames.quartermaster

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import cz.cvut.fit.android.cerberus.presentation.prototype.SingleFragmentActivity

class QuartermasterGameActivity() : SingleFragmentActivity() {

    companion object Creator {
        fun newIntent(context: Context): Intent {
            return Intent(context, QuartermasterGameActivity::class.java)
        }
    }

    override fun createFragment(): Fragment {
        return QuartermasterGameFragment.newInstance()
    }
}