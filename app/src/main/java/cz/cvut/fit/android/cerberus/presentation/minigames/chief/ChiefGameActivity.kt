package cz.cvut.fit.android.cerberus.presentation.minigames.chief

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import cz.cvut.fit.android.cerberus.presentation.SingleFragmentActivity

class ChiefGameActivity() : SingleFragmentActivity() {

    companion object Creator {
        fun newIntent(context: Context): Intent {
            return Intent(context, ChiefGameActivity::class.java)
        }
    }

    override fun createFragment(): Fragment {
        return ChiefGameFragment.newInstance()
    }
}