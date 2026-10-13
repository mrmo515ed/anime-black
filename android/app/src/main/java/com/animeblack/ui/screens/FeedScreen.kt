package com.animeblack.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

data class AnimePost(
    val id: String,
    val title: String,
    val author: String,
    val imageUrl: String,
    val likes: Int,
    val comments: Int,
    val tag: String
)

@Composable
fun AnimeHomeScreen() {
    val posts = remember {
        listOf(
            AnimePost("1", "Naruto Shippuden", "@animewave", "https://images.unsplash.com/photo-1542204165-65bf26472b9b?auto=format&fit=crop&w=900&q=80", 1240, 92, "#anime"),
            AnimePost("2", "Attack on Titan", "@otakuclub", "https://images.unsplash.com/photo-1517849845537-4d257902454a?auto=format&fit=crop&w=900&q=80", 980, 41, "#action"),
            AnimePost("3", "Jujutsu Kaisen", "@mangaverse", "https://images.unsplash.com/photo-1526379095098-d400fd0bf935?auto=format&fit=crop&w=900&q=80", 2100, 150, "#dark"),
        )
    }

    val stories = remember {
        listOf("One Piece", "Demon", "JJK", "Solo", "AOT")
    }

    Scaffold(
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.surface,
                tonalElevation = 4.dp
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    listOf(
                        Icons.Default.Home to "Home",
                        Icons.Default.Search to "Search",
                        Icons.Default.Notifications to "Alerts",
                        Icons.Default.Favorite to "Likes",
                        Icons.Default.Person to "Profile"
                    ).forEach { (icon, label) ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(icon, contentDescription = label, tint = MaterialTheme.colorScheme.primary)
                            Text(label, fontSize = 10.sp)
                        }
                    }
                }
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFF111111)),
            contentPadding = PaddingValues(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Anime Black",
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    Icon(Icons.Default.Share, contentDescription = "Share", tint = Color.White)
                }
            }

            item {
                LazyRow(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    items(stories) { story ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Box(
                                modifier = Modifier
                                    .size(62.dp)
                                    .clip(CircleShape)
                                    .background(
                                        brush = androidx.compose.ui.graphics.Brush.linearGradient(
                                            listOf(Color(0xFFF15BB5), Color(0xFF9B5DE5), Color(0xFF00BBF9))
                                        )
                                    ),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(story.take(1), color = Color.White, fontWeight = FontWeight.Bold)
                            }
                            Text(story, color = Color.White, fontSize = 12.sp)
                        }
                    }
                }
            }

            items(posts) { post ->
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(18.dp),
                    colors = CardDefaults.cardColors(containerColor = Color(0xFF1C1C1C))
                ) {
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(CircleShape)
                                    .background(Color(0xFF9B5DE5)),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(post.author.take(1).removePrefix("@").uppercase(), color = Color.White)
                            }
                            Spacer(modifier = Modifier.width(12.dp))
                            Column {
                                Text(post.author, color = Color.White, fontWeight = FontWeight.Bold)
                                Text(post.tag, color = MaterialTheme.colorScheme.primary, fontSize = 12.sp)
                            }
                        }

                        AsyncImage(
                            model = post.imageUrl,
                            contentDescription = post.title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(220.dp),
                            contentScale = ContentScale.Crop
                        )

                        Column(modifier = Modifier.padding(12.dp)) {
                            Text(post.title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 22.sp)
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(text = "❤ ${post.likes}", color = Color.White)
                                Text(text = "💬 ${post.comments}", color = Color.White)
                                Text(text = "↗ Share", color = MaterialTheme.colorScheme.primary)
                            }
                        }
                    }
                }
            }
        }
    }
}
