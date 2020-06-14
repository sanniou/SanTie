package com.saniou.santieba.kts

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.sanniou.support.extensions.getViewModel

fun <T : ViewModel> Fragment.getNavViewModel(
    clazz: Class<T>,
    navGraphId: Int
) = findNavController().getBackStackEntry(navGraphId).getViewModel(clazz)

inline fun <reified T : ViewModel> Fragment.getNavViewModel(navGraphId: Int) =
    getNavViewModel(T::class.java, navGraphId)