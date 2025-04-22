package com.example.faculdadetrabalho

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var resultDisplay: TextView
    private var currentNumber = ""
    private var firstNumber = 0.0
    private var currentOperation: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialização dos componentes
        resultDisplay = findViewById(R.id.resultDisplay)

        // Configuração dos botões numéricos
        val numberButtons = listOf(
            R.id.btn0, R.id.btn1, R.id.btn2, R.id.btn3,
            R.id.btn4, R.id.btn5, R.id.btn6,
            R.id.btn7, R.id.btn8, R.id.btn9
        )

        numberButtons.forEach { buttonId ->
            findViewById<Button>(buttonId).setOnClickListener {
                addNumber(findViewById<Button>(buttonId).text.toString())
            }
        }

        // Configuração dos botões de operação
        val operationButtons = listOf(
            R.id.btnPlus, R.id.btnMinus,
            R.id.btnMultiply, R.id.btnDivide
        )

        operationButtons.forEach { buttonId ->
            findViewById<Button>(buttonId).setOnClickListener {
                setOperation(findViewById<Button>(buttonId).text.toString())
            }
        }

        // Botão de igual
        findViewById<Button>(R.id.btnEquals).setOnClickListener { calculateResult() }

        // Botão de limpar
        findViewById<Button>(R.id.btnClear).setOnClickListener { clearCalculator() }
    }

    private fun addNumber(number: String) {
        currentNumber += number
        updateDisplay(currentNumber)
    }

    private fun setOperation(operation: String) {
        if (currentNumber.isNotEmpty()) {
            firstNumber = currentNumber.toDouble()
            currentOperation = operation
            currentNumber = ""
        }
    }

    private fun calculateResult() {
        if (currentNumber.isNotEmpty() && currentOperation != null) {
            val secondNumber = currentNumber.toDouble()
            val result = when (currentOperation) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "×" -> firstNumber * secondNumber
                "÷" -> if (secondNumber != 0.0) firstNumber / secondNumber else Double.NaN
                else -> 0.0
            }
            updateDisplay(result.toString())
            currentNumber = result.toString()
            currentOperation = null
        }
    }

    private fun clearCalculator() {
        currentNumber = ""
        firstNumber = 0.0
        currentOperation = null
        updateDisplay("0")
    }

    private fun updateDisplay(value: String) {
        resultDisplay.text = value
    }
}