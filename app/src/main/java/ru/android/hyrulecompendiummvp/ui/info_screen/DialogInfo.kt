package ru.android.hyrulecompendiummvp.ui.info_screen

import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import ru.android.hyrulecompendiummvp.R

class DialogInfo : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            builder.setTitle("Info")
                .setMessage("You may not have an internet connection")
                .setIcon(R.drawable.ic_baseline_info_24)
                .setPositiveButton("ok") { dialog, _ ->
                    activity?.onBackPressed()
                    dialog.cancel()
                }
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}