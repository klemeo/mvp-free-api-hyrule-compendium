package ru.android.hyrulecompendiummvp.ui

import android.os.Bundle
import android.view.View
import android.widget.Button
import ru.android.hyrulecompendiummvp.R
import ru.android.hyrulecompendiummvp.base.BaseFragment
import ru.android.hyrulecompendiummvp.ui.info_screen.InfoScreen

class MainScreen : BaseFragment(R.layout.fragment_main_screen) {

    private var monstersButton: Button? = null
    private var treasureButton: Button? = null
    private var materialsButton: Button? = null
    private var equipmentButton: Button? = null

    override fun initView(view: View, savedInstanceState: Bundle?) {
        with(view) {
            monstersButton = findViewById(R.id.monstersButton)
            treasureButton = findViewById(R.id.treasureButton)
            materialsButton = findViewById(R.id.materialsButton)
            equipmentButton = findViewById(R.id.equipmentButton)
        }

        monstersButton?.setOnClickListener {
            screensManager.showScreen(InfoScreen.newInstance("monsters"))
        }
        treasureButton?.setOnClickListener {
            screensManager.showScreen(InfoScreen.newInstance("treasure"))
        }
        materialsButton?.setOnClickListener {
            screensManager.showScreen(InfoScreen.newInstance("materials"))
        }
        equipmentButton?.setOnClickListener {
            screensManager.showScreen(InfoScreen.newInstance("equipment"))
        }

    }
}