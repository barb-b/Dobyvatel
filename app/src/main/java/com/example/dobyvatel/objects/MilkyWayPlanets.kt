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
                mercuryIsPlaying = true
            }
            "mercury" -> {
                mercuryIsPlaying = false
                mercuryDone = true
                venusIsPlaying = true
            }
            "venus" -> {
                venusIsPlaying = false
                venusDone = true
                earthIsPlaying = true
            }
            "earth" -> {
                earthIsPlaying = false
                earthDone = true
                marsIsPlaying = true
            }
            "mars" -> {
                marsIsPlaying = false
                marsDone = true
                jupiterIsPlaying = true
            }
            "jupiter" -> {
                jupiterIsPlaying = false
                jupiterDone = true
                saturnIsPlaying = true
            }
            "saturn" -> {
                saturnIsPlaying = false
                saturnDone = true
                uranusIsPlaying = true
            }
            "uranus" -> {
                uranusIsPlaying = false
                uranusDone = true
                neptuneIsPlaying = true
            }
            "neptune" -> {
                neptuneIsPlaying = false
                neptuneDone = true

            }
        }

    }
}