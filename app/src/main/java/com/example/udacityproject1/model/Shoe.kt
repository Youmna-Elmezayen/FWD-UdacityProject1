package com.example.udacityproject1.model


data class Shoe(var name: String, var size: Double, var company: String, var description: String,
                    var images: List<String> = mutableListOf())