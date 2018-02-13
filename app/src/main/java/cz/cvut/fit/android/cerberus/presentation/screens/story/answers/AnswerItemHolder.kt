package cz.cvut.fit.android.cerberus.presentation.story.answers

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import cz.cvut.fit.android.cerberus.R

class AnswerItemHolder(convertView: View) {

    var textView: TextView = convertView.findViewById(R.id.iAnswerTextView)
    var checkBox: CheckBox = convertView.findViewById(R.id.iAnswerCheckBox)
}