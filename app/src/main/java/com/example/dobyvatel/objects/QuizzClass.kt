package com.example.dobyvatel.objects

class QuizzClass {

    val otazka: String
    val odpoved1: String
    val odpoved2: String
    val spravnaodpoved: String

    constructor(otazka: String, odpoved1: String, odpoved2: String, spravnaodpoved: String) {
        this.otazka = otazka
        this.odpoved1 = odpoved1
        this.odpoved2 = odpoved2
        this.spravnaodpoved = spravnaodpoved
    }
}