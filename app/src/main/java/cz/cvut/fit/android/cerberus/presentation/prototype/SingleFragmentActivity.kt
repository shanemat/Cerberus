package cz.cvut.fit.android.cerberus.presentation.prototype

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import cz.cvut.fit.android.cerberus.R

abstract class SingleFragmentActivity() : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        wireUpView()
        attachFragment()
    }

    private fun wireUpView() {
        setContentView(R.layout.a_single_fragment)
    }

    private fun attachFragment() {
        val fragment = supportFragmentManager.findFragmentById(R.id.fragmentContainer)

        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                    .add(R.id.fragmentContainer, createFragment())
                    .commit()
        }
    }

    protected abstract fun createFragment(): Fragment
}