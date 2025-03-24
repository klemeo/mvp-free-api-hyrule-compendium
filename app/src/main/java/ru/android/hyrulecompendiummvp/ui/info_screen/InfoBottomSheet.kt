package ru.android.hyrulecompendiummvp.ui.info_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ru.android.hyrulecompendiummvp.R
import ru.android.hyrulecompendiummvp.base.args
import ru.android.hyrulecompendiummvp.ui.utils.gone

class InfoBottomSheet : BottomSheetDialogFragment() {

    companion object {

        fun newInstance(
            name: String? = null,
            category: String? = null,
            description: String? = null,
            attack: Int? = null,
            defense: Int? = null
        ) = InfoBottomSheet().args {

            name?.let { putString(ARG_NAME, it) }
            category?.let { putString(ARG_CATEGORY, it) }
            description?.let { putString(ARG_DESCRIPTION, it) }
            attack?.let { putInt(ARG_ATTACK, it) }
            defense?.let { putInt(ARG_DEFENSE, it) }

        }

        const val TAG = "InfoBottomSheet"

        private const val ARG_NAME = "ARG_NAME"
        private const val ARG_CATEGORY = "ARG_CATEGORY"
        private const val ARG_DESCRIPTION = "ARG_DESCRIPTION"
        private const val ARG_ATTACK = "ARG_ATTACK"
        private const val ARG_DEFENSE = "ARG_DEFENSE"

    }

    override fun getTheme(): Int {
        return R.style.CustomBottomSheetDialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.bottom_sheet_fragment, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nameText = view.findViewById<TextView>(R.id.nameText)
        val categoryText = view.findViewById<TextView>(R.id.categoryText)
        val linearLayout = view.findViewById<LinearLayout>(R.id.linearLayout)
        val attackText = view.findViewById<TextView>(R.id.attackText)
        val defenseText = view.findViewById<TextView>(R.id.defenseText)
        val descriptionText = view.findViewById<TextView>(R.id.descriptionText)

        when (arguments?.getString(ARG_CATEGORY)) {
            "equipment" -> {
                attackText.text = arguments?.getInt(ARG_ATTACK).toString()
                defenseText.text = arguments?.getInt(ARG_DEFENSE).toString()
            }

            else -> linearLayout.gone()
        }
        arguments?.getString(ARG_NAME)?.let { nameText.text = it }
        arguments?.getString(ARG_CATEGORY)?.let { categoryText.text = it }
        arguments?.getString(ARG_DESCRIPTION)?.let { descriptionText.text = it }
    }

}