package com.babi.oneDayStudy.web.resolver

import org.springframework.stereotype.Component

@Component
class FooResolver {
    fun isGt10(no: Long): Boolean{
        if(no > 10) {
            return true
        }
        else {
            return false
        }
    }
}