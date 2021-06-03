package ru.android.hyrulecompendiummvp.ui.utils

import androidx.fragment.app.Fragment
import ru.android.hyrulecompendiummvp.ui.info_screen.DialogInfo

fun Fragment.showDialogNoInternet() {
    val dialog = DialogInfo()
    val manager = childFragmentManager
    dialog.show(manager, "dialogInfo")
}