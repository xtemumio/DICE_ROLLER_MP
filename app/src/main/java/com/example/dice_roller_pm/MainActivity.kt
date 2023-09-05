package com.example.dice_roller_pm

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.dice_roller_pm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val diceList = mutableListOf<Int>() // Lista per memorizzare i risultati dei dadi
    private lateinit var adapter: ArrayAdapter<Int> // Adattatore per collegare la lista alla vista

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Collega il gestore di eventi al pulsante
        binding.button.setOnClickListener { rollDice() }

        // Ottieni una riferimento alla ListView nel layout
        val listView = findViewById<ListView>(R.id.listView)

        // Crea un adattatore per visualizzare i risultati della lista
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, diceList)

        // Collega l'adattatore alla ListView
        listView.adapter = adapter
    }

    private fun rollDice() {
        // Ottieni il numero di facce e il numero di dadi dalle caselle di testo nell'interfaccia utente
        val numFaces = binding.face.text.toString().toInt()
        val numDice = binding.dice.text.toString().toInt()

        diceList.clear() // Pulisci la lista prima di aggiungere nuovi risultati

        // Crea un oggetto Dice con il numero di facce e di dadi specificato
        val dice = Dice(numFaces, numDice)

        // Ottieni i risultati dei lanci di dadi
        val result = dice.result()

        // Aggiungi i nuovi risultati alla lista
        diceList.addAll(result)

        // Notifica all'adattatore che i dati sono cambiati, in modo che la ListView venga aggiornata
        adapter.notifyDataSetChanged()
    }
}

class Dice(private val numFaces: Int, private val numDice: Int) {

     fun roll(): Int {
        return (1..numFaces).random() // Simula il lancio di un dado e restituisce un numero casuale
    }

    fun result(): List<Int> {
        val result: MutableList<Int> = mutableListOf()
        var i = 0

        // Esegui il lancio dei dadi il numero di volte specificato e aggiungi i risultati alla lista
        while (i < numDice) {
            result.add(roll())
            i++
        }

        return result // Restituisci la lista dei risultati dei lanci dei dadi
    }
}
