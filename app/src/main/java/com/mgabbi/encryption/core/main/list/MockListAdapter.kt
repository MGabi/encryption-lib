package com.mgabbi.encryption.core.main.list

import androidx.recyclerview.widget.DiffUtil
import com.mgabbi.encryption.MockBinding
import com.mgabbi.encryption.R
import com.mgabbi.encryption.data.models.MockItem
import com.mgabbi.encryption.shared.base.BaseAdapter
import org.jetbrains.anko.sdk27.coroutines.onClick

class MockListAdapter : BaseAdapter<MockItem, MockBinding>(
    R.layout.item_mock,
    object : DiffUtil.ItemCallback<MockItem>() {
        override fun areItemsTheSame(oldItem: MockItem, newItem: MockItem) =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: MockItem, newItem: MockItem) =
            oldItem == newItem
    }) {

    var onClick: (MockItem) -> Unit = {}

    override fun bind(binding: MockBinding, item: MockItem) {
        binding.root.onClick { onClick(item) }
    }
}
