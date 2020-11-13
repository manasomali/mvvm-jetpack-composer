package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.activity.viewModels
import androidx.compose.foundation.Icon
import androidx.compose.ui.platform.setContent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.observe
import kotlinx.android.synthetic.main.activity_main.*
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData


class MainActivity : AppCompatActivity() {
    private val viewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setContent {
            MaterialTheme {
                myApp(viewModel.soma)
            }
        }
    }
    @Composable
    fun myApp(somaData: LiveData<Int>){
        val soma by somaData.observeAsState()

        Scaffold(
            topBar = {

            },
            bodyContent = {
                Column (
                    modifier = Modifier.fillMaxWidth().fillMaxHeight(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    Text(soma.toString(), fontSize = 30.sp)
                }

            },
            floatingActionButton = {
                FloatingActionButton(onClick = {
                    viewModel.incremento(1)
                }){

                    Icon(Icons.Filled.Add)
                }
            }
        )
    }
}