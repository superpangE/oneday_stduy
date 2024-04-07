package com.babi.oneDayStudy.web.controller

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@ExtendWith(SpringExtension::class)
@AutoConfigureMockMvc
class FooControllerTest(
        @Autowired
        private val mockMvc: MockMvc
){

    @Test
    fun `preAuthorize 검증에 false로 걸리면 403 에러 발생`(){
        mockMvc.perform(
                get("/{no}", 5)
        )
                .andExpect(status().isForbidden)
    }
    @Test
    fun `preAuthorize 검증에 true가 된다면 로직 정상 수행`(){
        mockMvc.perform(
                get("/{no}", 15)
        )
                .andExpect(status().isOk)
    }
}