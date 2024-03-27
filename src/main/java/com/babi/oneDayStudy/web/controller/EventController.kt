package com.babi.oneDayStudy.web.controller

import com.babi.oneDayStudy.web.event.publisher.EventPublisher
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class EventController(
        val eventPublisher: EventPublisher
) {

    @PostMapping
    fun userAdd(){
        eventPublisher.createUser("babi", 12)
    }
}