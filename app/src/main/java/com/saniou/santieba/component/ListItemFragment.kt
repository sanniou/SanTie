package com.saniou.santieba.component

import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.saniou.santieba.R
import com.saniou.santieba.databinding.ActivityListBinding
import com.saniou.santieba.viewmodel.ListItemViewModel
import com.sanniou.support.extensions.getViewModel
import com.sanniou.support.widget.recyclerview.OnHeaderClickListener
import com.sanniou.support.widget.recyclerview.PinnedHeaderItemDecoration

const val LIST_VIEW_MODEL = "class"
const val LIST_MAP = "map"

open class ListItemFragment<T : ListItemViewModel> : SanBaseFragment<T>() {

    open fun getLayoutManager(): RecyclerView.LayoutManager? = null

    open fun onBinding(binding: ActivityListBinding) = Unit

    override fun createViewModel() =
        getViewModelInstance().apply {
            initParam(
                arguments?.getSerializable(LIST_MAP) as? HashMap<String, String> ?: mapOf()
            )
        }

    open fun getViewModelInstance() =
        getViewModel(arguments?.getSerializable(LIST_VIEW_MODEL) as Class<T>)

    final override fun getLayoutRes() = R.layout.activity_list

    final override fun onBindingCreated(binding: ViewDataBinding) {
        binding as ActivityListBinding

        onBinding(binding)

        var customerLayoutManager = false
        getLayoutManager()
            ?.apply {
                customerLayoutManager = true
                binding.recycler.layoutManager = this
            }

        binding.customerLayoutManager = customerLayoutManager

        if (viewModel.getHeaderType() > 0) {
            binding.recycler.addItemDecoration(
                PinnedHeaderItemDecoration
                    .Builder(viewModel.getHeaderType())
                    .enableDivider(false)
                    .setClickIds(*viewModel.getHeaderClickable())
                    .setHeaderClickListener(object : OnHeaderClickListener {
                        override fun onHeaderLongClick(view: View?, id: Int, position: Int) {
                            viewModel.handlerHeaderLongClick(id, position)
                        }

                        override fun onHeaderClick(view: View?, id: Int, position: Int) {
                            viewModel.handlerHeaderClick(id, position)
                        }
                    })
                    .create()
            )
        }
        if (viewModel.autoRefresh) {
            viewModel.refresh()
        }
    }

    fun ListItemViewModel.setViewModelValue(argumentKey: String, valueKey: String? = null) {
        this.setValue(valueKey ?: argumentKey, requireArguments().getString(argumentKey)!!)
    }
}
