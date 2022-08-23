package com.yep.doublecollapsingtoolbar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
    }

    private fun TabLayout.setupTabLayout() {
        if (this.tabCount == 0) {
            this.addTab(this.newTab().setText("Tab 1"))
            this.addTab(this.newTab().setText("Tab 2"))
        }
    }
}