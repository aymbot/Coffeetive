package com.example.coffeetive

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat

import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentManager
import androidx.navigation.ui.NavigationUI
import com.example.coffeetive.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var drawer: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        drawer = binding.drawerLayout

        setSupportActionBar(binding.toolbar)
        navView.setNavigationItemSelectedListener(this)
        
        val toggle = ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()

    }



    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.nav_homeFragment -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
            }
            R.id.nav_coffeeRegistrationFragment -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, CoffeeRegistrationFragment()).commit()
            }
            R.id.nav_statisticsFragment -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, StatisticsFragment()).commit()
            }
            R.id.nav_aboutFragment -> {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, AboutFragment()).commit()
            }

        }
        drawer.closeDrawer(GravityCompat.START)
        return true
    }


}
