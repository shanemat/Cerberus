package cz.cvut.fit.android.cerberus.presentation.screens.minigames.archaeologist

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import cz.cvut.fit.android.cerberus.presentation.prototype.SingleFragmentActivity

class ArchaeologistGameActivity() : SingleFragmentActivity() {

    companion object Creator {
        fun newIntent(context: Context): Intent {
            return Intent(context, ArchaeologistGameActivity::class.java)
        }
    }

    override fun createFragment(): Fragment {
        return ArchaeologistGameFragment.newInstance()
    }
}