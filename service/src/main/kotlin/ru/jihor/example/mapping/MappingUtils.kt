package ru.jihor.example.mapping

import java.math.BigInteger
import java.time.LocalDate
import java.time.Period.between

/**
 *
 * @author jihor (jihor@ya.ru)
 *         Created on 09.07.2019
 */
fun birthDateToAge(birthDate: LocalDate) = BigInteger.valueOf(between(birthDate, LocalDate.now()).years.toLong())