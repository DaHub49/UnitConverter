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
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
}

// Create new Composable with Columns:
@Composable
fun UnitConverter(){
    Column (// modifier property inside the normal brackets:
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
        Text(
            text = "Unit Converter",
            modifier = Modifier.padding(100.dp))
        //Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(value = "", onValueChange = {
            /*
            {} implement logic here if needed
            Anonymous functions are single-use functions that don't have names.
             */
        })
        Spacer(modifier = Modifier.height(16.dp))
        // Row: Here all the elements will be stacked alongside each other:
        Row {
            Box{
                Button(onClick = { /*TODO*/ }){
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down") // contentDescription for accessibility
                }
            }
            Box{
                Button(onClick = { /*TODO*/ }){
                    Text("Select")
                    Icon(Icons.Default.ArrowDropDown,
                        contentDescription = "Arrow Down") // contentDescription for accessibility
                }
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("[Result]")
    }
}

@Preview(showBackground = true)
@Composable
fun UnitConverterPreview(){
    UnitConverter()
}