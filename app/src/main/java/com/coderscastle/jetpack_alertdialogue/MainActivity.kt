package com.coderscastle.jetpack_alertdialogue

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.coderscastle.jetpack_alertdialogue.ui.theme.JetpackAlertDialogueTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackAlertDialogueTheme {
                AlertDialogue()
            }
        }
    }
}

@Composable
fun AlertDialogue() {

    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
       Button(onClick = { showDialog = true }) {
            Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Icon")
        }

        if (showDialog) {

            AlertDialog(
                onDismissRequest = {showDialog = false},
                icon = {
                    Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete Icon")
                },
                title = { Text(text ="Alert !!!" ) },
                text = { Text(text ="Are you really want to delete this file ?" ) },
                confirmButton = {
                    Button(
                        onClick = {
                            showDialog = false
                            Toast.makeText(context, "Deleted", Toast.LENGTH_SHORT).show()
                        }) {
                        Text(text = "Yes")
                    }
                },
                dismissButton = {
                    Button(onClick = { showDialog = false }) {
                        Text(text = "No")
                    }
                })
        }
    }
}