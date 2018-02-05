package cz.cvut.fit.android.cerberus.presentation.minigames.translator

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import cz.cvut.fit.android.cerberus.presentation.SingleFragmentActivity

class TranslatorGameActivity() : SingleFragmentActivity() {

    companion object Creator {
        fun newIntent(context: Context): Intent {
            return Intent(context, TranslatorGameActivity::class.java)
        }
    }

    override fun createFragment(): Fragment {
        return TranslatorGameFragment.newInstance()
    }
}