package com.example.dobyvatel.objects

class QuizzClass {

    val question: String
    val answer1: String
    val answer2: String
    val correctAns: String

    constructor(question: String, answer1: String, answer2: String, correctAns: String) {
        this.question = question
        this.answer1 = answer1
        this.answer2 = answer2
        this.correctAns = correctAns
    }
}