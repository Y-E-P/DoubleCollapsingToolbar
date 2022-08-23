package com.yep.doublecollapsingtoolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.LayoutParams.*
import com.google.android.material.tabs.TabLayout
import com.yep.doublecollapsingtoolbar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (binding.mainRecyclerView.adapter == null) {
            binding.mainRecyclerView.adapter = RecyclerAdapter()
            binding.mainRecyclerView.layoutManager = LinearLayoutManager(this)
            binding.mainRecyclerView.isNestedScrollingEnabled = true
        }
        binding.mainTabLayoutFirst.setupTabLayout()
        binding.mainTabLayoutSecond.setupTabLayout()
        binding.mainImageCollapsingToolbarFirst.tag = false
        binding.appbarLayout.addOnOffsetChangedListener(object : AppBarStateChangeListener() {
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?) {
                when (state) {
                    State.COLLAPSED -> {
                        setBlockLayout(false)
                    }
                    else -> {}
                }
            }
        }
        )
        binding.appbarLayout2.addOnOffsetChangedListener(object : AppBarStateChangeListener() {
            override fun onStateChanged(appBarLayout: AppBarLayout?, state: State?) {
                when (state) {
                    State.EXPANDED -> {
                        setBlockLayout(true)
                    }
                    else -> {}
                }
            }
        }
        )
    }

    private fun TabLayout.setupTabLayout() {
        if (this.tabCount == 0) {
            this.addTab(this.newTab().setText("Tab 1"))
            this.addTab(this.newTab().setText("Tab 2"))
        }
    }

    fun setBlockLayout(state: Boolean) {
        binding.mainImageCollapsingToolbarFirst.updateLayoutParams<AppBarLayout.LayoutParams> {
            scrollFlags = if (state) {
                SCROLL_FLAG_ENTER_ALWAYS or SCROLL_FLAG_SCROLL or SCROLL_FLAG_SNAP
            } else {
                SCROLL_FLAG_EXIT_UNTIL_COLLAPSED or SCROLL_FLAG_SCROLL or SCROLL_FLAG_SNAP
            }
        }
    }
}