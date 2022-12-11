package com.metehanbolat.uistructurecompose.visualizing.sortingwithanimation.domain.model

data class SortInfo(
    val currentItem: Int,
    val shouldSwap: Boolean,
    val hadNoEffect: Boolean
)
