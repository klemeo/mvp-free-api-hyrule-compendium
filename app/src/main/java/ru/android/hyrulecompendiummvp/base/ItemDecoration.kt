package ru.android.hyrulecompendiummvp.base

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

class ItemDecoration(private val spanCount: Int, private val spacing: Int) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {

        val layoutParams = view.layoutParams as StaggeredGridLayoutManager.LayoutParams

        if (layoutParams.isFullSpan) {
            outRect.set(0, 0, 0, 0)
        } else {
            val spanIndex = layoutParams.spanIndex
            val itemCount = parent.adapter!!.itemCount

            val leftEdge = spanIndex == 0
            val rightEdge = spanIndex == spanCount - 1

            val topEdge = spanIndex < spanCount
            val bottomEdge = parent.getChildLayoutPosition(view) >= itemCount - spanCount

            val halfSpacing = spacing / 2

            outRect.set(
                if (leftEdge) 0 else halfSpacing,
                if (topEdge) 0 else halfSpacing,
                if (rightEdge) 0 else halfSpacing,
                if (bottomEdge) 0 else spacing
            )
        }
    }
}