package za.co.howtogeek.unitconverter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
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
    Column {
        // Here all the UI elements will b e stacked below each other:
        /* There are 3 different types of text fields:
           (1) Text("Unit Converter")
           (2) BasicTextField()
           (3) OutlinedTextField()
         */
        Text("Unit Converter")
        OutlinedTextField(value = "", onValueChange = {
            /*
            {} implement logic here if needed
            Anonymous functions are single-use functions that don't have names.
             */
        })

        // Here all the elements will be stacked alongside each other:
        Row {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    UnitConverterTheme {

    }
}