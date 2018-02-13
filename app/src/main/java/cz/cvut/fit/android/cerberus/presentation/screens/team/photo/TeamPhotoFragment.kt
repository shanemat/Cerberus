package cz.cvut.fit.android.cerberus.presentation.screens.team.photo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.business.ManagerFactory
import kotlinx.android.synthetic.main.f_photo_detail.*

class TeamPhotoFragment internal constructor() : Fragment() {

    companion object Creator {
        fun newInstance(): TeamPhotoFragment {
            return TeamPhotoFragment()
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_photo_detail, container, false)
    }

    override fun onStart() {
        super.onStart()

        loadTeamPhoto()
    }

    private fun loadTeamPhoto() {
        val manager = ManagerFactory.getPhotoManager()
        val photo = manager.getTeamPhoto(activity!!)

        photoDetailImageView.setImageBitmap(photo)
    }
}