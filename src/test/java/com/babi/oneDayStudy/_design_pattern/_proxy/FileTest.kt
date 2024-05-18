package com.babi.oneDayStudy._design_pattern._proxy

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class FileTest{

    @Test
    fun `proxyTest`(){
        val file = ProxyFile("file1")
        val file2 = ProxyFile("file2")

        println("> Constructor End")

        println(file.read())
        println(file2.read())
    }
}