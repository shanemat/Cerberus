package cz.cvut.fit.android.cerberus.presentation.screens.team.photo

import android.content.Context
import android.content.Intent
import android.support.v4.app.Fragment
import cz.cvut.fit.android.cerberus.presentation.prototype.SingleFragmentActivity

class TeamPhotoActivity() : SingleFragmentActivity() {

    companion object Creator {
        fun newIntent(context: Context): Intent {
            return Intent(context, TeamPhotoActivity::class.java)
        }
    }

    override fun createFragment(): Fragment {
        return TeamPhotoFragment.newInstance()
    }
}