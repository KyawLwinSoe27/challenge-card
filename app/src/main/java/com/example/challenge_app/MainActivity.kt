package com.example.challenge_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challenge_app.data.ChallengeCard
import com.example.challenge_app.data.challengeCards
import com.example.challenge_app.ui.theme.AppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   App()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    Scaffold(
        topBar = { TopAppBarApp() }
    ) {
        it ->
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center,
            content = ColumnLayout(it)
        )
    }
}

@Composable
private fun GridLayout(it: PaddingValues): @Composable() (BoxScope.() -> Unit) = {
   LazyVerticalGrid(columns = GridCells.Adaptive(128.dp), contentPadding  = it) {
    items(challengeCards.size) {
        index -> CardItem(challengeCard = challengeCards[index], index = index)
    }
   }
}

@Composable
private fun ColumnLayout(it: PaddingValues): @Composable() (BoxScope.() -> Unit) =
    {
        LazyColumn(contentPadding = it, modifier = Modifier.animateContentSize(animationSpec = spring(
            dampingRatio = Spring.DampingRatioNoBouncy,
            stiffness = Spring.StiffnessMedium
        ))) {
            items(challengeCards) { item ->
                CardItem(challengeCard = item, index = challengeCards.indexOf(item))
            }
        }

    }


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBarApp(modifier: Modifier = Modifier){
    TopAppBar(title = { Text(text = "30 days of Wellness") })
}

@Composable
fun CardItem(challengeCard: ChallengeCard, index: Int) {
    var expanded by remember { mutableStateOf(false) }
    Card(modifier = Modifier
        .padding(10.dp).clickable { expanded = !expanded }) {
        Column(modifier = Modifier.padding(10.dp)) {
            Text("Day ${index+1}")
            Text(stringResource(id = challengeCard.title))
            Image(painter = painterResource(id = challengeCard.image), contentDescription = stringResource(
                id = challengeCard.title
            ),  modifier = Modifier
                .fillMaxWidth() // Set the Image to take the full width,
                .height(100.dp)
                    , contentScale = ContentScale.FillWidth)
            if(expanded) {
                Text(stringResource(id = challengeCard.desc))
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AppTheme {
        App()
    }
}