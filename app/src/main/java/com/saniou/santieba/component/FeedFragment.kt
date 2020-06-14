package com.saniou.santieba.component

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.saniou.santieba.MainNavigationDirections
import com.saniou.santieba.R
import com.saniou.santieba.kts.changeMenu
import com.saniou.santieba.viewmodel.FeedViewModel
import com.sanniou.support.extensions.getActivityViewModel
import com.sanniou.support.extensions.getViewModel

class FeedFragment : SanBaseFragment<FeedViewModel>() {

    override fun createViewModel() = getActivityViewModel<FeedViewModel>()

    override fun getLayoutRes() = R.layout.activity_feed

    override fun onBindingCreated(binding: ViewDataBinding) {

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        changeMenu(R.menu.nav_home, Observer {
            when (it) {
                R.id.home_sign ->
                    findNavController()
                        .navigate(MainNavigationDirections.actionGlobalUserMsign())
                R.id.home_search -> {
                    findNavController()
                        .navigate(MainNavigationDirections.actionGlobalSearchFragment())
                }
            }
        })
        super.onViewCreated(view, savedInstanceState)
    }
}
