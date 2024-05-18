package com.babi.oneDayStudy._design_pattern._singleton

class Admin private constructor(){

    companion object{
        private var instance: Admin? = null

        fun getInstance(): Admin {
            if(this.instance == null){
                this.instance = Admin()
            }
            return this.instance ?: throw RuntimeException()
        }
    }
}