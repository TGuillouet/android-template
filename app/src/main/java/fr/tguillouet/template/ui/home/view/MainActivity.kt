package fr.tguillouet.template.ui.home.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.tguillouet.template.ui.common.BaseActivity
import fr.tguillouet.template.R
import fr.tguillouet.template.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}