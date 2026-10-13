package com.animeblack.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

data class FeedItem(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val category: String,
    val likes: Int
)

class AnimeRepository {
    fun getFeed(): Flow<List<FeedItem>> = flowOf(
        listOf(
            FeedItem("1", "One Piece", "Adventure, action, and iconic scenes.", "https://images.unsplash.com/photo-1531259683007-016a7b628fc3?auto=format&fit=crop&w=900&q=80", "Action", 1280),
            FeedItem("2", "Jujutsu Kaisen", "Dark energy and emotional story arcs.", "https://images.unsplash.com/photo-1515879218367-8466d910aaa4?auto=format&fit=crop&w=900&q=80", "Dark Fantasy", 2240),
            FeedItem("3", "Demon Slayer", "Beautiful visuals and battle moments.", "https://images.unsplash.com/photo-1533158307587-6a3d6d5ac5f3?auto=format&fit=crop&w=900&q=80", "Adventure", 1860)
        )
    )
}
