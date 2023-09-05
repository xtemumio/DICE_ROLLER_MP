package com.example.dice_roller_pm

import org.junit.Test
import org.junit.Assert.assertTrue
import org.junit.Assert.*


class ExampleUnitTest {

    @Test

    fun generates_number() {
        val numFaces = 6
        val numDice = 3
        val dice=Dice(numFaces,numDice)
        val rollResult = dice.roll()
        assertTrue("The value of rollResult was not between 1 and 6", rollResult in 1..6)

    }
    @Test
    fun control_dice() {

        val numFaces = 6
        val numDice = 3
        val dice = Dice(numFaces, numDice)
        val result = dice.result()
        assertEquals(numDice, result.size)
    }
    @Test
    fun testDiceRollInRange() {
        val numFaces = 6
        val numDice = 3
        val dice = Dice(numFaces, numDice)
        val result = dice.result()
        assertTrue(result.all { it in 1..numFaces })
    }
}