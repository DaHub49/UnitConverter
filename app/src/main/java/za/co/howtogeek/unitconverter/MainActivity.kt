package za.co.howtogeek.unitconverter

import android.os.Bundle
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
        var inputUnit by remember { mutableStateOf("Centimetres") }
        var outputUnit by remember { mutableStateOf("Metres") }
        var inputExpanded by remember { mutableStateOf(false) }
        var outputExpanded by remember { mutableStateOf(false) }
        val conversionFactor = remember { mutableStateOf(0.01) }

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
            }, //Add comma after onValueChange closing } to add other elements:
                label = { Text("Enter value")}
            )
            Spacer(modifier = Modifier.height(16.dp))
            // Row: Here all the elements will be stacked alongside each other:
            Row {
                Box {
                    Button(onClick = { /*TODO*/ }) {
                        Text("Select")
                        Icon(Icons.Default.ArrowDropDown,
                            contentDescription = "Arrow Down") // contentDescription for accessibility
                    }
                    DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                        DropdownMenuItem(
                            text = { Text("Centimetres") },
                            onClick = { /*TODO*/ }
                        )
                        DropdownMenuItem(
                            text = { Text("Metres") },
                            onClick = { /*TODO*/ }
                        )
                        DropdownMenuItem(
                            text = { Text("Feet") },
                            onClick = { /*TODO*/ }
                        )
                        DropdownMenuItem(
                            text = { Text("Millimetres") },
                            onClick = { /*TODO*/ }
                        )
                    }
                } // (DropdownMenu here)

                // Add a Spacer between the 2 boxes:
                Spacer(modifier = Modifier.width(16.dp))

                // Box2 (other DropdownMenu here):
                Box {
                    Button(onClick = { /*TODO*/ }) {
                        Text("Select")
                        Icon(
                            Icons.Default.ArrowDropDown,
                            contentDescription = "Arrow Down"
                        ) // contentDescription for accessibility
                    }
                    DropdownMenu(expanded = false, onDismissRequest = { /*TODO*/ }) {
                        DropdownMenuItem(
                            text = { Text("Centimetres") },
                            onClick = { /*TODO*/ }
                        )
                        DropdownMenuItem(
                            text = { Text("Metres") },
                            onClick = { /*TODO*/ }
                        )
                        DropdownMenuItem(
                            text = { Text("Feet") },
                            onClick = { /*TODO*/ }
                        )
                        DropdownMenuItem(
                            text = { Text("Millimetres") },
                            onClick = { /*TODO*/ }
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text("[Result]")
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun UnitConverterPreview() {
        UnitConverter()
    }
}