package com.example.retrofitdog.apiary

data class apiaryResponceDTO(
    val question: String,
    val choices: String)

data class apiaryResponceGetDTO(val question: String, val choices: List<choices>)
data class choices(val choice: String, val votes: Int)
