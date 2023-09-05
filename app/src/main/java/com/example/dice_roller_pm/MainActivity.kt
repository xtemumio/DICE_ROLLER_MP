package com.example.dice_roller_pm

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.dice_roller_pm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val diceList = mutableListOf<Int>()
    private lateinit var adapter: ArrayAdapter<Int>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener { rollDice() }

        val listView = findViewById<ListView>(R.id.listView)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, diceList)
        listView.adapter = adapter
    }

    private fun rollDice() {
        val numFaces = binding.face.text.toString().toInt()
        val numDice = binding.dice.text.toString().toInt()

        diceList.clear() // Pulisci la lista prima di aggiungere nuovi risultati

        val dice = Dice(numFaces, numDice)
        val result = dice.result()
        diceList.addAll(result) // Aggiungi i nuovi risultati alla lista

        // Notifica all'adapter che i dati sono cambiati
        adapter.notifyDataSetChanged()
    }
}

class Dice(private val numFaces: Int, private val numDice: Int) {

    private fun roll(): Int {
        return (1..numFaces).random()
    }

    fun result(): List<Int> {
        val result: MutableList<Int> = mutableListOf()
        var i = 0
        while (i < numDice) {
            result.add(roll())
            i++
        }
        return result
    }
}