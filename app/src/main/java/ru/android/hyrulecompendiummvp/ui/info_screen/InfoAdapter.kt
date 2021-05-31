package ru.android.hyrulecompendiummvp.ui.info_screen

import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_image.view.*
import ru.android.hyrulecompendiummvp.R
import ru.android.hyrulecompendiummvp.app.models.pres_model.HyruleDataPresModel
import ru.android.hyrulecompendiummvp.base.RecyclerViewAdapter

class InfoAdapter : RecyclerViewAdapter<HyruleDataPresModel>() {

    var onClick: (HyruleDataPresModel) -> Unit = {}

    override val viewHolderLayoutId: Int = R.layout.item_image

    override fun bindModel(holder: ViewHolder, model: HyruleDataPresModel) {
        with(holder.itemView) {

            Glide.with(context)
                .load(model.image)
                .into(imagePreview)

            setOnClickListener { onClick(model) }

        }
    }
}