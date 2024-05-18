package com.babi.oneDayStudy._design_pattern._singleton

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class AdminTest{

    @Test
    fun `싱글톤은 여러개의 인스턴스를 가져오더라도 모두 동일하다`(){
        // given & when
        val admin1 = Admin.getInstance()
        val admin2 = Admin.getInstance()

        // then
        assertThat(admin1).isEqualTo(admin2)

    }
}