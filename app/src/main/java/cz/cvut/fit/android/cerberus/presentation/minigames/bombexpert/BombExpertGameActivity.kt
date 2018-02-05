package cz.cvut.fit.android.cerberus.presentation.minigames.bombexpert

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import cz.cvut.fit.android.cerberus.presentation.SingleFragmentActivity

class BombExpertGameActivity() : SingleFragmentActivity() {

    companion object Creator {
        fun newIntent(context: Context): Intent {
            return Intent(context, BombExpertGameActivity::class.java)
        }
    }

    override fun createFragment(): Fragment {
        return BombExpertGameFragment.newInstance()
    }
}