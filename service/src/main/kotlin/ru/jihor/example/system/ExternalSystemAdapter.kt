package ru.jihor.example.system

import ru.jihor.example.model.Request

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 07.07.2019
 */
interface ExternalSystemAdapter<R> {
    fun getData(request: Request): R
}