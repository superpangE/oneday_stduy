package com.babi.oneDayStudy._design_pattern._decorator

class RealFile(
        private val fileInfo: String
): File {

    init {
        println("${fileInfo} - RealFile Constructor Call")
    }
    override fun read(): String {
        return "${this.fileInfo} - Read Call"
    }
}