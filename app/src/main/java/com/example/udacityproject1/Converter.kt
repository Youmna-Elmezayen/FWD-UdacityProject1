package com.example.udacityproject1

import androidx.databinding.InverseMethod

object Converter
{
    @InverseMethod("stringToDouble")
    @JvmStatic
    fun doubleToString(value: Double) : String
    {
        return value.toString()
    }

    @JvmStatic
    fun stringToDouble(value: String) : Double
    {
        if (value.isEmpty())
        {
            return 0.0
        }
        else
        {
            return value.toDouble()
        }
    }
}