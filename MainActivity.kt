package com.example.conversormoeda

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    ConversorMoeda()
                }
            }
        }
    }
}

@Composable
fun ConversorMoeda() {
    val cotacao = 5.0

    var valorDolar by remember { mutableStateOf("") }
    var valorReal by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Conversor de Moeda",
            style = MaterialTheme.typography.titleLarge
        )

        Text(text = "Cotação fixa: 1 US$ = R$ 5,00")

        TextField(
            value = valorDolar,
            onValueChange = { valorDolar = it },
            label = { Text("Valor em Dólar (US$)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        TextField(
            value = valorReal,
            onValueChange = { valorReal = it },
            label = { Text("Valor em Real (R$)") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Button(
                onClick = {
                    val dolar = valorDolar.replace(',', '.').toDoubleOrNull()
                    if (dolar != null) {
                        valorReal = (dolar * cotacao).toString()
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Converter para Real")
            }

            Button(
                onClick = {
                    val real = valorReal.replace(',', '.').toDoubleOrNull()
                    if (real != null) {
                        valorDolar = (real / cotacao).toString()
                    }
                },
                modifier = Modifier.weight(1f)
            ) {
                Text("Converter para Dólar")
            }
        }
    }
}
