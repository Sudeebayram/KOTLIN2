package com.example.jcuygulama13

import android.os.Bundle
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.jcuygulama13.ui.theme.JCuygulama13Theme
import com.example.jcuygulama13.R
import com.example.jcuygulama13.ui.theme.JCuygulama13Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color(0xFFFF0000).toArgb()),
            //navigationBarStyle = SystemBarStyle.light(Color(0xFFFF0000).toArgb())
        )

        setContent {
            JCuygulama13Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(modifier = Modifier.padding(innerPadding)) {
                        Greeting(name = "World")
                        myApp()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = colorResource(id = R.color.purple_200)
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JCuygulama13Theme {
        Greeting("Android")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myApp(modifier: Modifier = Modifier) {
    Column {
        // Top Bar
        TopAppBar(
            title = { Text(text = "Welcome Application") },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = colorResource(id = R.color.purple_200)
            ),
            actions = {
                Image(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "my Image"
                )
            },
            navigationIcon = {
                Image(
                    modifier = Modifier.size(50.dp),
                    painter = painterResource(id = R.drawable.img),
                    contentDescription = "my Image"
                )
            }
        )

        // Text
        Text(text = "Sude", modifier = modifier)

        // Button
        Button(modifier = modifier, onClick = { /*TODO*/ }) {
            Text(text = "Giriş Yap")
        }

        // TextField
        var degisken by remember { mutableStateOf("Sude") }
        TextField(value = degisken, onValueChange = { degisken = it })

        // Switch
        var ischecked by remember { mutableStateOf(false) }
        Switch(modifier = modifier, checked = ischecked, onCheckedChange = { ischecked = it })

        // Checkbox
        Checkbox(checked = ischecked, onCheckedChange = { ischecked = it })

        // RadioButton
        var selected by remember { mutableStateOf("") }
        RadioButton(selected = selected == "Option 1", onClick = { selected = "Option 1" })


        Row {
            Text(modifier = modifier, text = "Sude")
            Spacer(modifier = modifier.size(50.dp))
            Text(modifier = modifier, text = "Bayram")
        }


        Box(modifier = modifier) {
            Image(
                modifier = modifier.size(150.dp).padding(10.dp),
                painter = painterResource(id = R.drawable.img),
                contentDescription = "my Image"
            )
            Text(text = "SUDE")
        }


        AndroidView(factory = {
            WebView(it).apply {
                loadUrl("https://www.udemy.com/")
            }
        })

        // Card
        Card(
            modifier = modifier.padding(15.dp),
            elevation = CardDefaults.elevatedCardElevation(defaultElevation = 10.dp),
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.purple_200)
            ),
            shape = RoundedCornerShape(45.dp)
        ) {
            Text(modifier = modifier.padding(16.dp), text = "Card")
        }

//        var showDialog by remember {
//            mutableStateOf(false) }
//
//        Button ( modifier = modifier, onClick = { showDialog = true}){
//            Text(text = "Click")
//        }
//        if (showDialog){
//            // AlertDialog
//            AlertDialog(
//                onDismissRequest = {
//                    showDialog = false
//                },
//                confirmButton = {
//                    Button(onClick = { }) {
//                        Text(text = "Tamam")
//                    }
//                },
//                dismissButton = {
//                    Button(onClick = {
//                        showDialog = false
//                    }) {
//                        Text(text = "İptal")
//                    }
//                },
//                title = { Text(text = "Başlık") },
//                text = { Text(text = "Açıklama") })
//        }


    }
}