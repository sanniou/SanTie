package com.saniou.santieba.component

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.blankj.utilcode.util.ToastUtils
import com.saniou.santieba.MainNavigationDirections
import com.saniou.santieba.R
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.dialog.LMessageDialog
import com.saniou.santieba.kts.changeMenu
import com.saniou.santieba.model.api.reqeust.AccountUtil
import com.saniou.santieba.viewmodel.HomeViewModel
import com.saniou.santieba.vo.ForumItem
import com.sanniou.multiitemkit.ItemClickHelper
import com.sanniou.multiitemkit.OnItemClickListener
import com.sanniou.support.exception.ExceptionEngine
import com.sanniou.support.extensions.getActivityViewModel
import com.sanniou.support.utils.ResourcesUtils.getColor
import kotlinx.coroutines.launch

class HomeFragment : ListItemFragment<HomeViewModel>() {

    override fun getViewModelInstance(): HomeViewModel {
        return getActivityViewModel()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        arguments = Bundle().apply {
            putSerializable(LIST_VIEW_MODEL, HomeViewModel::class.java)
        }
        super.onCreate(savedInstanceState)
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

    override fun onBinding(binding: ActivityListBinding) {
        ItemClickHelper.attachToRecyclerView(
            binding.recycler,
            OnItemClickListener {
                when (val data = it.item) {
                    is ForumItem -> {
                        findNavController().navigate(
                            HomeFragmentDirections.actionNavbarHomeToForum(data.name)
                        )
                    }
                    else -> {
                    }
                }
                false
            }
        )
        binding.root.setBackgroundColor(getColor(R.color.backgroundColorPress))
        if (viewModel.list.isNotEmpty()) {
            return
        }


        if (!AccountUtil.isLoggedIn(requireContext())) {

            findNavController().navigate(R.id.action_navbar_home_to_user_login)
            return
        }
        if (AccountUtil.getCookie() == null) {
            LMessageDialog(requireContext())
                .setMessage(getString(R.string.message_dialog_update_stoken))
                .title(getString(R.string.title_dialog_update_stoken))
                .okListener { _, _ ->
                    findNavController().navigate(R.id.action_navbar_home_to_user_update)

                }
                .show()
            return
        }

        launch {
            try {
                AccountUtil.updateUserInfo()
            } catch (e: Exception) {
                ToastUtils.showShort(ExceptionEngine.handleMessage(e))
                LMessageDialog(requireContext())
                    .setMessage(getString(R.string.message_dialog_logged_in_expired))
                    .title(getString(R.string.title_dialog_logged_in_expired))
                    .okListener { _, _ ->
                        findNavController().navigate(R.id.action_navbar_home_to_user_login)

                    }
                    .show()
            }

        }

        super.onBinding(binding)
    }
}