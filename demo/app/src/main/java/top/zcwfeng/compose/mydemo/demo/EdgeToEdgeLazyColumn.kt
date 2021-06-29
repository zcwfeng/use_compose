package top.zcwfeng.compose.mydemo.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Face
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.stringResource
import androidx.core.view.WindowCompat
import dev.chrisbanes.accompanist.insets.LocalWindowInsets
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.navigationBarsHeight
import top.zcwfeng.compose.mydemo.R
import java.util.*

class EdgeToEdgeLazyColumn : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Turn off the decor fitting system windows, which means we need to through handling
        // insets
        WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            // Update the system bars to be translucent
            val systemUiController = rememberSystemUiController()
            val useDarkIcons = MaterialTheme.colors.isLight
            SideEffect {
                systemUiController.setSystemBarsColor(Color.Transparent, darkIcons = useDarkIcons)
            }

            AccompanistSampleTheme {
                ProvideWindowInsets {
                    Sample()
                }
            }
        }
    }
}

@Composable
private fun Sample() {
    Scaffold(
        topBar = {
            // We use TopAppBar from accompanist-insets-ui which allows us to provide
            // content padding matching the system bars insets.
            TopAppBar(
                title = { Text(stringResource(R.string.insets_title_list)) },
                backgroundColor = MaterialTheme.colors.surface.copy(alpha = 0.95f),
                contentPadding = rememberInsetsPaddingValues(
                    LocalWindowInsets.current.statusBars,
                    applyBottom = false,
                ),
                modifier = Modifier.fillMaxWidth()
            )
        },
        bottomBar = {
            // We add a spacer as a bottom bar, which is the same height as
            // the navigation bar
            Spacer(Modifier.navigationBarsHeight().fillMaxWidth())
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* TODO */ },) {
                Icon(
                    imageVector = Icons.Default.Face,
                    contentDescription = "Face icon"
                )
            }
        }
    ) { contentPadding ->
        Box {
            // We apply the contentPadding passed to us from the Scaffold
            LazyColumn(
                contentPadding = contentPadding,
                modifier = Modifier.fillMaxSize(),
            ) {
                items(items = listItems) { imageUrl ->
                    ListItem(imageUrl, Modifier.fillMaxWidth())
                }
            }
        }
    }
}

private val listItems = List(40) { randomSampleImageUrl(it) }