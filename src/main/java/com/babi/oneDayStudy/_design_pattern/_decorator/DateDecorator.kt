package com.babi.oneDayStudy._design_pattern._decorator

import java.time.LocalDateTime

class DateDecorator(override val file: File) : Decorator() {

    override fun read(): String {
        return "${file.read()} - when : ${LocalDateTime.now()}"
    }
}