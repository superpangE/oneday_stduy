package com.babi.oneDayStudy.web.controller

import org.springframework.http.ResponseEntity
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class FooController {

    @GetMapping("/{no}")
    @PreAuthorize("@fooResolver.isGt10(#no)")
    fun foo(
            @PathVariable no: Long
    ): ResponseEntity<String>{
        return ResponseEntity.ok("yes")
    }
}