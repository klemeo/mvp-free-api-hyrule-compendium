package ru.android.hyrulecompendiummvp.ui

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_main_screen.*
import ru.android.hyrulecompendiummvp.R
import ru.android.hyrulecompendiummvp.base.BaseFragment

class MainScreen : BaseFragment(R.layout.fragment_main_screen) {

    override fun initView(view: View, savedInstanceState: Bundle?) {

        monstersButton.setOnClickListener {

        }
        treasureButton.setOnClickListener {

        }
        materialsButton.setOnClickListener {

        }
        equipmentButton.setOnClickListener {

        }

    }
}