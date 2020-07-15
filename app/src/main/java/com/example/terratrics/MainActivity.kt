package com.example.terratrics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var toolbar: Toolbar

    /*This is the native layout for this activity as it holds the navigation drawer*/
    private lateinit var drawerLayout: DrawerLayout

    /*This is the view used to make the navigation drawer*/
    private lateinit var navigationView: NavigationView

    /*This variable is used as a flag to keep a check as to which menu item inside the navigation drawer is checked*/
    private var previousitem: MenuItem? = null
    lateinit var framelayout: FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        framelayout=findViewById(R.id.frame)
            toolbar = findViewById(R.id.toolbar)
            drawerLayout = findViewById(R.id.drawerlayout)
            navigationView = findViewById(R.id.navigation_view)
        setSupportActionBar(toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
        openDashboard()
        var actionBarDrawerToggle = ActionBarDrawerToggle(this@MainActivity,drawerlayout,
            R.string.open_drawer,
            R.string.close_drawer
        )
        drawerlayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()
        navigationView.setNavigationItemSelectedListener {
            if(previousitem!=null)
            {
                previousitem?.isChecked = false
            }
            it.isCheckable=true
            it.isChecked=true
            previousitem=it

            when(it.itemId)
            {
                R.id.home ->
                {
                    openDashboard()
                    drawerlayout.closeDrawers()
                }
                R.id.crops ->
                {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        HomeFragment()
                    )
                        .commit()
                    supportActionBar?.title="Crops"
                    drawerlayout.closeDrawers()
                }
                R.id.fertilizers ->
                {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        HomeFragment()
                    )
                        .commit()
                    supportActionBar?.title="Fertilizers"
                    drawerlayout.closeDrawers()

                }
                R.id.market ->
                {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        HomeFragment()
                    )
                        .commit()
                    supportActionBar?.title="Market"
                    drawerlayout.closeDrawers()
                }

                R.id.govtschmes ->
                {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        HomeFragment()
                    )
                        .commit()
                    supportActionBar?.title="Govt Schemes"
                    drawerlayout.closeDrawers()
                }
                R.id.weather ->
                {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        WeatherFragment()
                    )
                        .commit()
                    supportActionBar?.title="Weather"
                    drawerlayout.closeDrawers()

                }
                R.id.newtechnologies ->
                {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        HomeFragment()
                    )
                        .commit()
                    supportActionBar?.title="Technologies"
                    drawerlayout.closeDrawers()
                }
                R.id.settings ->
                {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        HomeFragment()
                    )
                        .commit()
                    supportActionBar?.title="Settings"
                    drawerlayout.closeDrawers()

                }
                R.id.doctorfarm ->
                {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        HomeFragment()
                    )
                        .commit()
                    supportActionBar?.title="Doctor Form"
                    drawerlayout.closeDrawers()
                }
                R.id.machinary ->
                {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.frame,
                        MachineryFragment()
                    )
                        .commit()
                    supportActionBar?.title="Machinery"
                    drawerlayout.closeDrawers()
                }
            }

            return@setNavigationItemSelectedListener true
        }

    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var id=item.itemId
        if(id==android.R.id.home)
        {
            drawerlayout.openDrawer(GravityCompat.START)
        }
        return super.onOptionsItemSelected(item)
    }
    fun openDashboard() {
        supportFragmentManager.beginTransaction().replace(
            R.id.frame,
            HomeFragment()
        ).commit()
        supportActionBar?.title = "Home"
        navigationView.setCheckedItem(R.id.home)
    }
    override fun onBackPressed() {
        var frag=supportFragmentManager.findFragmentById(R.id.frame)
        when(frag){

            !is HomeFragment -> openDashboard()
            else -> super.onBackPressed()
        }

    }

}