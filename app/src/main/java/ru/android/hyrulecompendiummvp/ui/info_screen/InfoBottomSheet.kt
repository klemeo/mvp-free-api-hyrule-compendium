package ru.android.hyrulecompendiummvp.ui.info_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.android.hyrulecompendiummvp.R

class InfoBottomSheet : BottomSheetDialogFragment() {

    companion object {
        const val TAG = "InfoBottomSheet"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.bottom_sheet_fragment, container, false)

}