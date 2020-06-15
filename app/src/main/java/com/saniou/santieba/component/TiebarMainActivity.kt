package com.saniou.santieba.component

import android.view.Menu
import android.view.MenuItem
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.saniou.santieba.R
import com.saniou.santieba.databinding.ActivityTiebarMainBinding
import com.saniou.santieba.viewmodel.TiebarMainViewModel
import com.sanniou.support.extensions.getViewModel

class TiebarMainActivity : SanBaseActivity<TiebarMainViewModel>() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    private var inflatedMenu = 0

    override fun getLayoutRes() = R.layout.activity_tiebar_main

    override fun createViewModel() = getViewModel<TiebarMainViewModel>()

    override fun onBindingCreated(binding: ViewDataBinding) {
        binding as ActivityTiebarMainBinding
        super.onBindingCreated(binding)
        setSupportActionBar(binding.actionBar)
        val navController = findNavController(R.id.nav_host_fragment)

        viewModel.appTitle.observe(this, Observer {
            binding.actionBar.title = it
        })
        viewModel.appmenu.observe(this, Observer {
            // 恢复完全显示的状态
            binding.appBar.setExpanded(true, true)
            if (inflatedMenu != viewModel.appmenu.value) {
                invalidateOptionsMenu()
            }
        })

        viewModel.appmenu.value = R.menu.empty

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navbar_home, R.id.navbar_explore, R.id.navbar_msg, R.id.navbar_store
            ), binding.drawerLayout
        )


        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val value = viewModel.appmenu.value
        if (value != null && inflatedMenu != value) {
            menu?.clear()
            menuInflater.inflate(value, menu);
            inflatedMenu = value
        }
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.menuClicked.value = item.itemId
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp() =
        findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
}

