package ru.my.mainactivity.impl.presentation.model

enum class BottomBarScreenEnum {
    Search,
    Favourite,
    Responses,
    Messages,
    Profile;

    companion object {
        fun getFromInt(number: Int): BottomBarScreenEnum {
            return entries.find { it.ordinal == number } ?: Search
        }
    }

}