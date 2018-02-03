package cz.cvut.fit.android.cerberus.presentation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.AdapterView
import cz.cvut.fit.android.cerberus.R
import cz.cvut.fit.android.cerberus.presentation.base.BaseFragment
import cz.cvut.fit.android.cerberus.presentation.drawer.DrawerAdapter
import cz.cvut.fit.android.cerberus.presentation.drawer.DrawerItem
import cz.cvut.fit.android.cerberus.presentation.dummy.DummyFragment
import cz.cvut.fit.android.cerberus.presentation.minigames.MiniGamesFragment
import cz.cvut.fit.android.cerberus.presentation.results.ResultsFragment
import cz.cvut.fit.android.cerberus.presentation.settings.SettingsFragment
import cz.cvut.fit.android.cerberus.presentation.story.StoryFragment
import cz.cvut.fit.android.cerberus.presentation.team.TeamFragment
import kotlinx.android.synthetic.main.a_drawer.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        prepareBaseView()
        prepareDrawer()
    }

    private fun prepareBaseView() {
        setContentView(R.layout.a_drawer)
        supportActionBar?.hide()

        val baseFragment = BaseFragment.newInstance()
        displayFragmentOnScreen(baseFragment)
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

        items.add(DrawerItem(R.drawable.ic_story, R.string.drawer_menu_story))
        items.add(DrawerItem(R.drawable.ic_games, R.string.drawer_menu_games))
        items.add(DrawerItem(R.drawable.ic_results, R.string.drawer_menu_results))
        items.add(DrawerItem(R.drawable.ic_team, R.string.drawer_menu_team))
        items.add(DrawerItem(R.drawable.ic_settings, R.string.drawer_menu_settings))

        return items
    }

    private fun onDrawerItemClicked(item: DrawerItem) {
        val fragment = selectFragmentByPickedOption(item)
        displayFragmentOnScreen(fragment)
        closeDrawer()
    }

    private fun selectFragmentByPickedOption(item: DrawerItem): Fragment {
        return when (item.textResourceID) {
            R.string.drawer_menu_story -> StoryFragment.newInstance()
            R.string.drawer_menu_games -> MiniGamesFragment.newInstance()
            R.string.drawer_menu_results -> ResultsFragment.newInstance()
            R.string.drawer_menu_team -> TeamFragment.newInstance()
            R.string.drawer_menu_settings -> SettingsFragment.newInstance()
            else -> {
                val optionName = resources.getString(item.textResourceID)
                return DummyFragment.newInstance(optionName)
            }
        }
    }

    private fun displayFragmentOnScreen(fragment: Fragment) {
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragmentFrame)

        if (currentFragment == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentFrame, fragment)
                    .commit()
        } else {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fragmentFrame, fragment)
                    .commit()
        }
    }

    private fun closeDrawer() {
        drawerLayout.closeDrawers()
    }
}
