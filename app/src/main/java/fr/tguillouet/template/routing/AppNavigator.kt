package fr.tguillouet.template.routing

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import fr.tguillouet.template.ui.common.BaseActivity
import fr.tguillouet.template.R
import fr.tguillouet.template.ui.home.view.MainActivity
import java.io.Serializable

class AppNavigator(private val activity: AppCompatActivity): Navigator {

    companion object {
        const val SCREEN_TYPE = "screen_type"
    }

    override fun showHome() {}
//    = navigateTo(getIntent<MainActivity>())

    private fun navigateTo(intent: Intent) {
        activity.startActivity(intent)
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out)
    }

    private inline fun <reified T : BaseActivity<*>> getIntent() = Intent(activity, T::class.java)
}

enum class ScreenType : Serializable {
    HOME,
    TECHNICIAN,
    USER,
}