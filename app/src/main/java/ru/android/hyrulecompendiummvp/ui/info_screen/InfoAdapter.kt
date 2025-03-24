package ru.android.hyrulecompendiummvp.ui.info_screen

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import ru.android.hyrulecompendiummvp.R
import ru.android.hyrulecompendiummvp.app.models.pres_model.HyruleDataPresModel
import ru.android.hyrulecompendiummvp.base.RecyclerViewAdapter
import ru.android.hyrulecompendiummvp.ui.utils.dp

class InfoAdapter : RecyclerViewAdapter<HyruleDataPresModel>() {

    var onClick: (HyruleDataPresModel) -> Unit = {}

    override val viewHolderLayoutId: Int = R.layout.item_image

    override fun bindModel(holder: ViewHolder, model: HyruleDataPresModel) {
        with(holder.itemView) {

            val imagePreview = findViewById<ImageView>(R.id.imagePreview)

            Glide.with(context)
                .load(model.image)
                .override(this.width, this.height)
                .transform(CenterCrop(), RoundedCorners(16.dp(context)))
                .into(imagePreview)

            setOnClickListener { onClick(model) }

        }
    }
}