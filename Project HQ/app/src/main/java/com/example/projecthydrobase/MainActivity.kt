package com.example.projecthydrobase

import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.commit
import com.example.projecthydrobase.databinding.ActivityMainBinding
import com.example.projecthydrobase.fragments.BeritaFragment
import com.example.projecthydrobase.fragments.BiodataFragment
import com.example.projecthydrobase.fragments.CuacaFragment
import com.example.projecthydrobase.fragments.KalkulatorFragment
import com.example.projecthydrobase.fragments.KontakFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        val toggle = ActionBarDrawerToggle(this, binding.drawerLayout, binding.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                replace(R.id.fragment_container, BiodataFragment())
            }
            binding.navView.setCheckedItem(R.id.nav_biodata)
        }

        binding.navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_biodata -> supportFragmentManager.commit { replace(R.id.fragment_container, BiodataFragment()) }
                R.id.nav_kontak -> supportFragmentManager.commit { replace(R.id.fragment_container, KontakFragment()) }
                R.id.nav_kalkulator -> supportFragmentManager.commit { replace(R.id.fragment_container, KalkulatorFragment()) }
                R.id.nav_cuaca -> supportFragmentManager.commit { replace(R.id.fragment_container, CuacaFragment()) }
                R.id.nav_berita -> supportFragmentManager.commit { replace(R.id.fragment_container, BeritaFragment()) }
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
