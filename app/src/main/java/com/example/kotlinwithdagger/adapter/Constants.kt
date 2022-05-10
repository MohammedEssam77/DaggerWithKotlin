package com.example.kotlinwithdagger.adapter

class Constants {
    val mediaURL = "http://img.thezagelapp.com/"
    fun loadSourceImg(sourceID: Int): String? {
        return mediaURL + "img/source/" + sourceID + ".jpg"
    }
}