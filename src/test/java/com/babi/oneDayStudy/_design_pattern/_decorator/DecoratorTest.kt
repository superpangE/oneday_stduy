package com.babi.oneDayStudy._design_pattern._decorator

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class DecoratorTest{
    @Test
    fun `데코레이터 패턴을 적용하여 응답값에 날짜 데이터가 추가되었다`(){

        val file = RealFile("file1")

        val decorator = DateDecorator(file)
        println(decorator.read())
    }
}