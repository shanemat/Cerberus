package cz.cvut.fit.android.cerberus.presentation

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.presentation.drawer.DrawerAdapter
import cz.cvut.fit.android.cerberus.presentation.drawer.DrawerItem
import kotlinx.android.synthetic.main.a_drawer.*

class MainActivity : AppCompatActivity() {

    //private val drawerToggle: ActionBarDrawerToggle = DrawerToggle(this, drawerLayout)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_drawer)

        supportActionBar?.hide()
        prepareDrawer()
    }

    private fun prepareDrawer() {
        val drawerItems = configureDrawerItems()
        drawer.adapter = DrawerAdapter(this, drawerItems)
        drawer.onItemClickListener = AdapterView.OnItemClickListener{_: AdapterView<*>, _: View, position: Int, _: Long ->
            onDrawerItemClicked(drawerItems[position])
        }
    }

    private fun configureDrawerItems(): ArrayList<DrawerItem> {
        val items = ArrayList<DrawerItem>()

        items.add(DrawerItem(R.drawable.ic_timer, R.string.drawer_menu_timer))
        items.add(DrawerItem(R.drawable.ic_story, R.string.drawer_menu_story))
        items.add(DrawerItem(R.drawable.ic_games, R.string.drawer_menu_games))
        items.add(DrawerItem(R.drawable.ic_results, R.string.drawer_menu_results))
        items.add(DrawerItem(R.drawable.ic_team, R.string.drawer_menu_team))
        items.add(DrawerItem(R.drawable.ic_settings, R.string.drawer_menu_settings))

        return items
    }

    private fun onDrawerItemClicked(item: DrawerItem) {
        // TODO add some meaningful fragment switching
        Toast.makeText(this, resources.getText(item.textResourceID),Toast.LENGTH_SHORT).show()
    }
}
