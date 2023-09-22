package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.Modelo.ListaHeroes
import com.example.superheroes.Modelo.Super
import com.example.superheroes.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
               AppTheme{
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Lista()
                }
            }
        }
    }
}
@Preview
@Composable
fun Lista(modifier: Modifier = Modifier){
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
    ) {
        //SE PASAN LOS OBJETOS A LA LISTA Y CADA OBJETO LLAMA A LA
        //FUNCION CARTAS
        items(ListaHeroes.heroes) { Super ->
            Cartas(Super)
        }
    }
}
@Composable
fun Cartas(heroe : Super, modifier: Modifier = Modifier) {
    Card(modifier = modifier.width(15.dp).height(30.dp)) {
        Row {
            Column {
                Text(
                    text = stringResource(id = heroe.nombresuper),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(16.dp,16.dp,16.dp,4.dp)
                )

                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        text = heroe.descripcion,
                        style = MaterialTheme.typography.labelMedium,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                }
            }
            Box {
                Image(
                    painter = painterResource(id = heroe.imagen),
                    contentDescription = null,
                    modifier = modifier
                        .size(width = 68.dp, height = 68.dp)
                        .aspectRatio(1f).padding(5.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}
