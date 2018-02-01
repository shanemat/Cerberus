package cz.cvut.fit.android.cerberus.drawer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import cz.cvut.fit.android.cerberus.R

class DrawerAdapter(context: Context, private var items: ArrayList<DrawerItem>)
    : ArrayAdapter<DrawerItem>(context, 0) {

    override fun getCount(): Int {
        return items.size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var currentView = convertView

        val item = items[position]
        val holder: DrawerItemHolder

        if (currentView == null) {
            val inflater = LayoutInflater.from(context)
            currentView = inflater.inflate(R.layout.i_drawer, null)

            holder = DrawerItemHolder(currentView)
            currentView.tag = holder

        } else {
            holder = currentView.tag as DrawerItemHolder
        }

        populateHolder(context, holder, item)
        return currentView!!
    }

    private fun populateHolder(context: Context, holder: DrawerItemHolder, item: DrawerItem) {
        val icon = context.resources.getDrawable(item.iconResourceID)
        holder.icon.setImageDrawable(icon)

        holder.name.text = context.resources.getText(item.textResourceID)
    }
}