package com.example.businesscard

import android.graphics.Color.parseColor
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CardDisplay(name = "Carl Cai", title ="Student" , phoneNumber = "123-123-1234", socialMedia = "@Carl", email = "carl@gmail.com")
                }
            }
        }
    }
}

@Composable
fun CardDisplay(name: String, title: String, phoneNumber: String,socialMedia: String, email: String, modifier: Modifier = Modifier){
    val mainImage = painterResource(R.drawable.pace_university_logo_svg)
    val phoneImage = painterResource(R.drawable._6854)
    val linkImage = painterResource(R.drawable.img_509783)
    val gmailImage = painterResource(R.drawable.gmail_logo_512px)
    Column(
          modifier =
          modifier
              .fillMaxSize()
              .background(Color(parseColor("#B3CBF2"))),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally
       )
             {
                Image(
                    painter =mainImage,
                    contentDescription ="Business card logo",
                    modifier.padding(bottom = 10.dp)
                )

                Text(
                    text = name,
                    fontSize =48.sp
                )
                Text(
                    text = title,
                    fontSize = 32.sp
                )
                 Row(
                     verticalAlignment = Alignment.CenterVertically,
                     modifier =Modifier.align(alignment = Alignment.Start)
                         .padding(start = 100.dp)
                         .padding(top = 100.dp)
                     ){
                    Image(
                        painter = phoneImage,
                        contentDescription = "Phone logo",
                        modifier.size(20.dp),

                    )
                     Text(
                         text = phoneNumber,
                         fontSize = 25.sp
                     )
                 }
                 Row(
                     verticalAlignment = Alignment.CenterVertically,
                     modifier =Modifier.align(alignment = Alignment.Start)
                         .padding(start = 100.dp)
                         .padding(top = 10.dp)
                 ){
                     Image(
                         painter = linkImage,
                         contentDescription = "Link image",
                         modifier.size(20.dp),

                         )
                     Text(
                         text = socialMedia,
                         fontSize = 25.sp
                     )
                 }
                 Row(
                     verticalAlignment = Alignment.CenterVertically,
                     modifier =Modifier.align(alignment = Alignment.Start)
                         .padding(start = 100.dp)
                         .padding(top = 10.dp)
                 ){
                     Image(
                         painter = gmailImage,
                         contentDescription = "email image",
                         modifier.size(20.dp),
                         )
                     Text(
                         text = email,
                         fontSize = 25.sp
                     )
                 }
            }
           
       }


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BusinessCardTheme {
        CardDisplay(name = "Carl Cai", title ="Student" , phoneNumber = "123-123-1234", socialMedia = "@Carl", email = "carl@gmail.com")
    }
}