package com.example.viewpagerexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pages = listOf(
            Page(
                title = "Page 1", fragment = PageFragment.newInstance(title = "Page 1")
            ),
            Page(
                title = "Page 2", fragment = PageFragment.newInstance(title = "Page 2")
            ),
            Page(
                title = "Page 3", fragment = PageFragment.newInstance(title = "Page 3")
            )
        )

        val adapter = PagerAdapter(this, pages)

        pager.adapter = adapter

        TabLayoutMediator(tab_layout, pager) { tab, position ->
            tab.text = pages[position].title
        }.attach()
    }
}