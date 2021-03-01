package fr.tguillouet.template.common.extensions

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import fr.tguillouet.template.R

fun FragmentActivity.showFragment(fragment: Fragment, @IdRes container: Int, addToBackStack: Boolean = false) {
    supportFragmentManager.beginTransaction().apply {
        if (addToBackStack) {
            addToBackStack(fragment.tag)
        }
    }
        .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
        .replace(container, fragment)
        .commitAllowingStateLoss()
}

fun FragmentActivity.goBack() {
    supportFragmentManager.popBackStack()
}