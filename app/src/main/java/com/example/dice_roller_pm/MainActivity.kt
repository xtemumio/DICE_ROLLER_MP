package com.example.dice_roller_pm

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.dice_roller_pm.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { rollDice() }

    }


    private fun rollDice() {

        val numFaces = binding.face.text.toString().toInt()
        val numDice = binding.dice.text.toString().toInt()
        val dice = Dice(numFaces, numDice)
        val result = dice.result()
        Log.d("prova", result.toString())
    }
}

class Dice(private val numFaces: Int, private val numDice: Int) {

    private fun roll(): Int {
        return (1..numFaces).random()
    }

    fun result(): MutableList<Int> {
        val result: MutableList<Int> = mutableListOf()
        var i = 0
        while (i < numDice) {
            result.add(roll())
            i++
        }
        return result
    }

}