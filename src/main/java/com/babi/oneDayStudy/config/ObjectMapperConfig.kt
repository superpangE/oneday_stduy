package com.babi.oneDayStudy.config

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.exc.InvalidFormatException
import com.fasterxml.jackson.databind.module.SimpleModule
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime
import java.time.ZoneId

@Configuration
class ObjectMapperConfig {

    @Bean
    fun objectMapper(): ObjectMapper {
        val simpleModule = SimpleModule()
        simpleModule.addDeserializer(LocalDateTime::class.java, TimeZoneDeserializer())
        return ObjectMapper().registerModules(simpleModule)
    }

    inner class TimeZoneDeserializer(): JsonDeserializer<LocalDateTime>() {
        override fun deserialize(jsonParser: JsonParser, deserializationContext: DeserializationContext): LocalDateTime {
            return try {
                InstantDeserializer.ZONED_DATE_TIME.deserialize(jsonParser, deserializationContext)
//                        .withZoneSameInstant(ZoneId.of("Asia/Seoul"))
//                        .withZoneSameInstant(ZoneId.of("+09:00"))
                        .withZoneSameInstant(ZoneId.of("UTC+9"))
                        .toLocalDateTime()
            } catch (e: InvalidFormatException){
                LocalDateTimeDeserializer.INSTANCE.deserialize(jsonParser, deserializationContext)
            }
        }

    }
}