package za.co.howtogeek.unitconverter

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import za.co.howtogeek.unitconverter.ui.theme.UnitConverterTheme
import kotlin.math.roundToInt

val TAG: String = "MainActivity -> "

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            UnitConverterTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //    content = { innerPadding -> 8.
                    UnitConverter()
                }
            }
        }
    }

    // Create new Composable with Columns:
    @Composable
    fun UnitConverter() {

        var inputValue by remember { mutableStateOf("") }
        var outputValue by remember { mutableStateOf("") }
        var inputUnit by remember { mutableStateOf("Metres") }
        var outputUnit by remember { mutableStateOf("Metres") }
        var inputExpanded by remember { mutableStateOf(false) }
        var outputExpanded by remember { mutableStateOf(false) }
        // The multiplier:
        val conversionFactor = remember { mutableStateOf(1.00) }
        val outputConversionFactor = remember { mutableStateOf(1.00) }

        // Create the convertUnits inside the UnitConverter() composable:
        fun convertUnits(){
            val inputValueDouble = inputValue.toDoubleOrNull() ?: 0.0 // ?: -elvis operator: return 0.0 if invalid input
            val result = (inputValueDouble * conversionFactor.value * 100 / outputConversionFactor.value).roundToInt() / 100.0 // not the "=" because not using "by" keyword in the declaration
            Log.i(TAG, "convertUnits:  result.toString(): ${result.toString()}")
            outputValue = result.toString()
        }

        Column(// modifier property inside the normal brackets:
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Here all the UI elements will b e stacked below each other:
            /* There are 3 different types of text fields:
               (1) Text("Unit Converter")
               (2) BasicTextField()
               (3) OutlinedTextField()
             */
            Text("Unit Converter")
            //modifier = Modifier.padding(100.dp))
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = inputValue,
                onValueChange = { // {} implement logic here if needed. Anonymous functions are single-use functions that don't have names.
                    // The logic goes here for when the value of the OutLinedTextField changes
                    inputValue = it
                    convertUnits()
                }, //Add comma after onValueChange closing } to add other elements:
                label = { Text("Enter value")}
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Row: Here all the elements will be stacked alongside each other:
            Row {
                // Input Box
                Box {
                    // Input Button
                    Button(onClick = { inputExpanded = true }) {
                        Text(inputUnit)
                        Icon(Icons.Default.ArrowDropDown,
                            contentDescription = "Arrow Down") // contentDescription for accessibility
                    }
                    DropdownMenu(expanded = inputExpanded, onDismissRequest = { inputExpanded = false }) {
                        DropdownMenuItem(
                            text = { Text("Centimetres") },
                            onClick = {
                                inputExpanded = false
                                inputUnit = "Centimetres"
                                conversionFactor.value = 0.01
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Metres") },
                            onClick = {
                                inputExpanded = false
                                inputUnit = "Metres"
                                conversionFactor.value = 1.0
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Feet") },
                            onClick = {
                                inputExpanded = false
                                inputUnit = "Feet"
                                conversionFactor.value = 0.3048
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Millimetres") },
                            onClick = {
                                inputExpanded = false
                                inputUnit = "Millimetres"
                                conversionFactor.value = 0.001
                                convertUnits()
                            }
                        )
                    }
                } // (DropdownMenu here)

                // Add a Spacer between the 2 boxes:
                Spacer(modifier = Modifier.width(16.dp))

                // Box2 (output box):
                Box {
                    // Output Button:
                    Button(onClick = { outputExpanded = true }) {
                        Text(outputUnit)
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Arrow Down"
                        ) // contentDescription for accessibility
                    }
                    DropdownMenu(expanded = outputExpanded, onDismissRequest = {outputExpanded = false }) {
                        DropdownMenuItem(
                            text = { Text("Centimetres") },
                            onClick = {
                                outputExpanded = false
                                outputUnit = "Centimetres"
                                outputConversionFactor.value = 0.01
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Metres") },
                            onClick = {
                                outputExpanded = false
                                outputUnit = "Metres"
                                outputConversionFactor.value = 1.00
                                convertUnits() }
                        )
                        DropdownMenuItem(
                            text = { Text("Feet") },
                            onClick = {
                                outputExpanded = false
                                outputUnit = "Feet"
                                outputConversionFactor.value = 0.3048
                                convertUnits()
                            }
                        )
                        DropdownMenuItem(
                            text = { Text("Millimetres") },
                            onClick = {
                                outputExpanded = false
                                outputUnit = "Millimetres"
                                outputConversionFactor.value = 0.001
                                convertUnits()
                            }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Result"
            Text("Result: $outputValue $outputUnit",
                style = MaterialTheme.typography.headlineMedium)
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun UnitConverterPreview() {
        UnitConverter()
    }
}