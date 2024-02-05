package com.nomaddeveloper.batucodegenerator.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.nomaddeveloper.batucodegenerator.R
import com.nomaddeveloper.batucodegenerator.databinding.ActivityMainBinding
import com.nomaddeveloper.batucodegenerator.ui.fragment.CodeGeneratorFragment
import com.nomaddeveloper.batucodegenerator.ui.fragment.CodeReaderFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val bottomNavigationMenu = binding.bottomNavMenu
        val defaultFragment = CodeGeneratorFragment()
        val fragmentManager = supportFragmentManager
        val containerId = R.id.main_activity_fragment_container

        replaceFragment(fragmentManager, defaultFragment, containerId)
        bottomNavigationMenu.menu.findItem(R.id.bottom_nav_code_generator).isChecked = true

        bottomNavigationMenu.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bottom_nav_code_generator -> {
                    replaceFragment(
                        fragmentManager,
                        CodeGeneratorFragment(),
                        containerId
                    )
                    return@setOnItemSelectedListener true
                }

                R.id.bottom_nav_code_reader -> {
                    replaceFragment(
                        fragmentManager,
                        CodeReaderFragment(),
                        containerId
                    )
                    return@setOnItemSelectedListener true
                }

                else -> false
            }
        }
    }
}

private fun replaceFragment(
    fragmentManager: FragmentManager,
    newFragment: Fragment,
    containerId: Int
) {
    val transaction: FragmentTransaction = fragmentManager.beginTransaction()
    transaction.replace(containerId, newFragment)
        .addToBackStack(null)
        .commit()
}