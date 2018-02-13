package cz.cvut.fit.android.cerberus.presentation.screens.drawer

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import cz.cvut.fit.android.cerberus.R

class DrawerItemHolder(convertView: View) {

    var icon: ImageView = convertView.findViewById(R.id.iDrawerImageView)
    var name: TextView = convertView.findViewById(R.id.iDrawerTextView)
}