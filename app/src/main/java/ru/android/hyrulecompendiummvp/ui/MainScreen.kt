package ru.android.hyrulecompendiummvp.ui

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_main_screen.*
import ru.android.hyrulecompendiummvp.R
import ru.android.hyrulecompendiummvp.base.BaseFragment
import ru.android.hyrulecompendiummvp.ui.info_screen.InfoScreen

class MainScreen : BaseFragment(R.layout.fragment_main_screen) {

    override fun initView(view: View, savedInstanceState: Bundle?) {

        monstersButton.setOnClickListener {
            screensManager.showScreen(InfoScreen.newInstance("monsters"))
        }
        treasureButton.setOnClickListener {
            screensManager.showScreen(InfoScreen.newInstance("treasure"))
        }
        materialsButton.setOnClickListener {
            screensManager.showScreen(InfoScreen.newInstance("materials"))
        }
        equipmentButton.setOnClickListener {
            screensManager.showScreen(InfoScreen.newInstance("equipment"))
        }

    }
}