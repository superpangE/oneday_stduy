package com.babi.oneDayStudy.web

import java.time.LocalDateTime

data class DateRequest(
        val date: LocalDateTime = LocalDateTime.now()
)
