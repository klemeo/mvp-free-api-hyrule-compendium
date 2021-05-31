package ru.android.hyrulecompendiummvp.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class RecyclerViewAdapter<T>: BaseDataAdapter<T, RecyclerViewAdapter<T>.ViewHolder>() {

    abstract val viewHolderLayoutId: Int

    abstract fun bindModel(holder: ViewHolder, model: T)

    open fun initViewHolder(holder: ViewHolder) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(parent).apply { initViewHolder(this) }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        bindModel(holder, data[position])

    inner class ViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            viewHolderLayoutId,
            parent,
            false
        )
    )

}