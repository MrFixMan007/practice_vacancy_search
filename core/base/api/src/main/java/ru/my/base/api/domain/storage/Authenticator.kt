package ru.my.base.api.domain.storage

interface Authenticator {

    fun isAuth(): Boolean
}