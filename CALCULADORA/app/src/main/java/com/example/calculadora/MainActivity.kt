@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadora.ui.theme.CALCULADORATheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CALCULADORATheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TipTimeLayout()
                }
            }
        }
    }
}
@Composable
fun EditNumberField( perroValue: String, perroOnValueCHange : (String) -> Unit,
    modifier: Modifier = Modifier) {

    TextField(value = perroValue, onValueChange = perroOnValueCHange,
        modifier = modifier,
        label = {
            Text(stringResource(R.string.bill_amount))
        }, singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

    )
}

@Composable
fun EditarPorcentaje( Valor: String, CambioValor: (String) -> Unit, modifier: Modifier= Modifier){
    TextField(value = Valor, onValueChange = CambioValor, modifier=modifier,
        label = {
            Text("TIP PERCENTAGE")
        }, singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))
}

@Preview
@Composable
fun TipTimeLayout() {
    Column(
        modifier = Modifier.padding(40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
   //VARIABLE CAMBIANTE DE VALOR
        var amountInput  by remember {
            mutableStateOf("0")
        }
        var Descuento  by remember {
            mutableStateOf("0")
        }
        //ASIGNAMOS EL VALOR SI NO ES NULO O ASIGNAMOS UN 0
        val amount = amountInput.toDoubleOrNull() ?: 0.0
        val desc = Descuento.toDoubleOrNull() ?: 0.0
        //LLAMAMOS A LA FUNCION CALCULAR TIP Y LA GUARDAMOS EN UNA VARIABLE
        val tip = calculateTip(amount,desc)

        Text(
            text = stringResource(R.string.calculate_tip),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        //INPUT CANTIDAD
        EditNumberField(
            perroValue = amountInput,
            perroOnValueCHange = { cualquiercosa-> amountInput = cualquiercosa }
            ,modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth())
        //INPUT PORCENTAJE
        EditarPorcentaje(
            Valor = Descuento,
            CambioValor = {CambioValor -> Descuento = CambioValor},
            modifier = Modifier
                .padding(bottom = 32.dp)
                .fillMaxWidth())

        Text(
            text = stringResource(R.string.tip_amount, tip),
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

private fun calculateTip(amount: Double, tipPercent: Double): String {
    val tip = tipPercent / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}