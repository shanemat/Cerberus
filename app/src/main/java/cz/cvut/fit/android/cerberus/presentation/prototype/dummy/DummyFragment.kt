package cz.cvut.fit.android.cerberus.presentation.prototype.dummy

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.cvut.fit.android.cerberus.R
import kotlinx.android.synthetic.main.f_main_dummy.*

class DummyFragment internal constructor() : Fragment() {

    private lateinit var optionName: String

    companion object Creator {

        const val ARGS_OPTION_NAME = "optionName"
        const val UNKNOWN_OPTION = "---"

        fun newInstance(optionName: String) : DummyFragment {
            val fragment = DummyFragment()

            val arguments = Bundle()
            arguments.putString(ARGS_OPTION_NAME, optionName)

            fragment.arguments = arguments
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        optionName = arguments?.getString(ARGS_OPTION_NAME) ?: UNKNOWN_OPTION
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_main_dummy, container, false)
    }

    override fun onStart() {
        super.onStart()

        setUpErrorTextView()
    }

    private fun setUpErrorTextView() {
        val errorText = resources.getString(R.string.unsupported_option, optionName)
        errorTextView.text = errorText
    }
}