package top.zcwfeng.compose.mydemo.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import top.zcwfeng.compose.mydemo.R

class ImageDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            NewsStoryStyleText()
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ImageStory() {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Image(
            imageVector = vectorResource(id = R.drawable.avatar_1),
            contentDescription = "avatar"
        )
        Text("A day in Shark Fin Cove")
        Text("Davenport, California")
        Text("December 2018")
    }
}

//@Preview(showBackground = true)
//@Composable
//fun NewsStoryImagePreview(){
//    NewsStoryStyleText()
//}



@Preview(showBackground = true)
@Composable
fun NewsStoryShape() {
//    val image = imageResource(R.drawable.ic_launcher_background)
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        val imageModifier = Modifier
            .preferredHeight(180.dp)
            .fillMaxWidth()
            .clip(shape = RoundedCornerShape(4.dp))

        Image(
            vectorResource(id = R.drawable.avatar_2),
            "avatar",
            modifier = imageModifier,
            contentScale = ContentScale.Crop
        )
        Spacer(Modifier.preferredHeight(16.dp))

        Text("A day in Shark Fin Cove")
        Text("Davenport, California")
        Text("December 2018")
    }
}

@Preview(showBackground = true)
@Composable
fun NewsStoryStyleText() {
//    val image = imageResource(R.drawable.ic_launcher_background)
    MaterialTheme {
        val typography = MaterialTheme.typography
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            val imageModifier = Modifier
                .preferredHeight(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(4.dp))

            Image(
                vectorResource(id = R.drawable.avatar_6),
                "avatar",
                modifier = imageModifier,
                contentScale = ContentScale.Crop
            )
            Spacer(Modifier.preferredHeight(16.dp))

            Text(
                "A day wandering through the sandhills " +
                        "in Shark Fin Cove, and a few of the " +
                        "sights I saw",
                style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis)
            Text("Davenport, California",
                style = typography.body2)
            Text("December 2018",
                style = typography.body2)
        }
    }
}




//@Preview(showBackground = true)
//@Composable
//fun NewsStoryImage2Preview() {
//    val image = imageResource(id = R.drawable.avatar_2)
//    Column(
//        modifier = Modifier.padding(16.dp)
//    ) {
//        val imageModifier = Modifier
//            .preferredHeight(180.dp)
//            .fillMaxWidth()
////        Image(
////            bitmap = image,
////            contentDescription = "avatar",
////            modifier = imageModifier,
////            contentScale = ContentScale.Crop,
////        )
//
//        Image(bitmap = image,"")
//        Spacer(Modifier.preferredHeight(16.dp))
//
//
//        Text("A day in Shark Fin Cove")
//        Text("Davenport, California")
//        Text("December 2018")
//    }
//}

