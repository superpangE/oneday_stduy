package com.babi.oneDayStudy.config

import com.babi.oneDayStudy.web.DateRequest
import com.fasterxml.jackson.databind.ObjectMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime
import java.time.OffsetDateTime
import java.time.ZoneOffset

@SpringBootTest
class ObjectMapperConfigTest(
        @Autowired private val objectMapper: ObjectMapper
){

    @Test
    fun `타임존 있는 데이터를 LocalDateTime으로 받고싶어`(){
        // given
        val now = LocalDateTime.now()
        val offsetDateTime = OffsetDateTime.of(now, ZoneOffset.of("+09:00"))
        val jsonString = "{\"date\": \"" + offsetDateTime + "\"}"
        // when
        val value = objectMapper.readValue(jsonString, DateRequest::class.java)
        // then
        assertThat(value.date).isEqualTo(LocalDateTime.from(now))
    }

    @Test
    fun `LocalDateTime 데이터타입이 그대로 들어온다면 타임존 변환 없이 들어온다`(){
        // given
        val now = LocalDateTime.now()
        val jsonString = "{\"date\": \"" + now + "\"}"
        // when
        val value = objectMapper.readValue(jsonString, DateRequest::class.java)
        // then
        assertThat(value.date).isEqualTo(LocalDateTime.from(now))
    }

    @Test
    fun `타임존이 'UTC'로 설정된 데이터가 들어오면 'UTC+09'를 적용하여 변환된다`(){
        // given
        val now = LocalDateTime.now()
        val offsetDateTime = OffsetDateTime.of(now, ZoneOffset.of("Z"))
        val jsonString = "{\"date\": \"" + offsetDateTime + "\"}"
        // when
        val value = objectMapper.readValue(jsonString, DateRequest::class.java)
        // then
        assertThat(value.date).isEqualTo(LocalDateTime.from(now.plusHours(9)))
    }
}