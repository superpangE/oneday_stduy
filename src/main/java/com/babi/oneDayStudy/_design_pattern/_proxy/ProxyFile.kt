package com.babi.oneDayStudy._design_pattern._proxy

class ProxyFile(
        private val fileInfo: String
):File {

    private var file: File? = null
    init {
        println("${fileInfo} - ProxyFile Constructor Call")
    }
    override fun read(): String {
        if(this.file == null){
            this.file = RealFile(fileInfo)
        }
        return this.file?.read() ?: throw RuntimeException()
    }
}