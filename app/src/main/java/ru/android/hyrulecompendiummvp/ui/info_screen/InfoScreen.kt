package ru.android.hyrulecompendiummvp.ui.info_screen

import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import ru.android.hyrulecompendiummvp.R
import ru.android.hyrulecompendiummvp.app.models.pres_model.HyruleInfoPresModel
import ru.android.hyrulecompendiummvp.base.ItemDecoration
import ru.android.hyrulecompendiummvp.base.MvpFragment
import ru.android.hyrulecompendiummvp.base.args
import ru.android.hyrulecompendiummvp.ui.utils.*

class InfoScreen : MvpFragment<Presenter>(), View {

    companion object {

        fun newInstance(
            category: String,
        ) = InfoScreen().args {
            putString(ARG_CATEGORY, category)
        }

        private const val ARG_CATEGORY = "ARG_CHARACTER_ID"
    }

    override val presenter by lazy {
        Presenter(
            view = this,
            category = requireArguments().getString(ARG_CATEGORY) ?: ""
        )
    }

    override val layout: Int = R.layout.fragment_monsters

    private val monstersAdapter by lazy {
        InfoAdapter().apply {
            onClick = {
                InfoBottomSheet.newInstance(
                    name = it.name,
                    category = it.category,
                    description = it.description,
                    attack = it.attack,
                    defense = it.defense
                ).show(childFragmentManager, InfoBottomSheet.TAG)
            }
        }
    }

    private var buttonBack: Button? = null
    private var recyclerView: RecyclerView? = null
    private var pbPost: ProgressBar? = null

    override fun initView(view: android.view.View, savedInstanceState: Bundle?) {
        with(view) {
            buttonBack = findViewById(R.id.buttonBack)
            recyclerView = findViewById(R.id.recyclerView)
            pbPost = findViewById(R.id.pbPost)
        }

        recyclerView?.apply {
            layoutManager = GridLayoutManager(this.context, 2)
            adapter = monstersAdapter
        }

        buttonBack?.setOnClickListener { presenter.closeScreen() }

    }

    override fun refreshHyruleInfo(hyruleInfo: HyruleInfoPresModel) {
        hyruleInfo.data?.let { monstersAdapter.setData(it) }
    }

    override fun showHyruleInfo(animated: Boolean) {
        when (animated) {
            true -> {
                recyclerView?.visible()
                pbPost?.invisible()
            }

            else -> {
                recyclerView?.invisible()
                pbPost?.gone()
            }
        }
    }

    override fun showInfoDialog() {
        showDialogNoInternet()
    }

}