package com.example.dobyvatel.objects

object MilkyWayPlanets {

    var sunDone = false
    var mercuryDone = false
    var venusDone = false
    var earthDone = false
    var marsDone = false
    var jupiterDone = false
    var saturnDone = false
    var uranusDone = false
    var neptuneDone = false

    var sunIsPlaying = false
    var mercuryIsPlaying = false
    var venusIsPlaying = false
    var earthIsPlaying = false
    var marsIsPlaying = false
    var jupiterIsPlaying = false
    var saturnIsPlaying = false
    var uranusIsPlaying = false
    var neptuneIsPlaying = false

    fun planetIsDone(planet: String) {
        when (planet) {
            "sun" -> {
                sunIsPlaying = false
                sunDone = true
            }
            "mercury" -> {
                mercuryIsPlaying = false
                mercuryDone = true
            }
            "venus" -> {
                venusIsPlaying = false
                venusDone = true
            }
            "earth" -> {
                earthIsPlaying = false
                earthDone = true
            }
            "mars" -> {
                marsIsPlaying = false
                marsDone = true
            }
            "jupiter" -> {
                jupiterIsPlaying = false
                jupiterDone = true
            }
            "saturn" -> {
                saturnIsPlaying = false
                saturnDone = true
            }
            "uranus" -> {
                uranusIsPlaying = false
                uranusDone = true
            }
            "neptune" -> {
                neptuneIsPlaying = false
                neptuneDone = true

            }
        }

    }
}