package com.example.viewpagerexample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_page.*

private const val KEY_ARGS_TITLE = "args_title"

class PageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_page, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.takeIf { it.containsKey(KEY_ARGS_TITLE) }?.apply {
            tv_title.text = getString(KEY_ARGS_TITLE)
        }
    }

    companion object {
        fun newInstance(title: String): PageFragment {
            val argument = Bundle().apply {
                putString(KEY_ARGS_TITLE, title)
            }

            return PageFragment().apply { arguments = argument }
        }
    }
}