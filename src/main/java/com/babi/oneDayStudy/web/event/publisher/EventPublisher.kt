package com.babi.oneDayStudy.web.event.publisher

import com.babi.oneDayStudy.web.event.dto.Foo
import org.springframework.context.ApplicationEventPublisher
import org.springframework.stereotype.Service

@Service
class EventPublisher(
        private val publisher: ApplicationEventPublisher
) {
    fun createUser(name: String, age: Int){
        publisher.publishEvent(Foo(name, age))
    }
}