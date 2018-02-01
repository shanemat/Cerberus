package cz.cvut.fit.android.cerberus.drawer

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import cz.cvut.fit.android.cerberus.R

class DrawerItemHolder(convertView: View) {

    var icon: ImageView = convertView.findViewById(R.id.iDrawerIcon)
    var name: TextView = convertView.findViewById(R.id.iDrawerText)
}