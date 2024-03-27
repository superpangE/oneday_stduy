package com.babi.oneDayStudy.web.event.listener

import com.babi.oneDayStudy.web.event.dto.Foo
import org.springframework.context.event.EventListener
import org.springframework.stereotype.Component

@Component
class EventListener {

    @EventListener
    fun ageListener(foo: Foo){
        println("age >> ${foo.age}")
    }

    @EventListener
    fun nameListener(foo:Foo){
        println("name >> ${foo.name}")
    }
}