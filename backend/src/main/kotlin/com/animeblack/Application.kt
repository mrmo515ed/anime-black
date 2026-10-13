import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        module()
    }.start(wait = true)
}

fun Application.module() {
    install(ContentNegotiation) {
        json()
    }

    routing {
        get("/health") {
            call.respond(mapOf("status" to "ok", "app" to "Anime Black"))
        }

        get("/feed") {
            call.respond(listOf(
                FeedItem("1", "One Piece", "Adventure anime", "https://images.unsplash.com/...", "Action", 1280),
                FeedItem("2", "Jujutsu Kaisen", "Dark fantasy action", "https://images.unsplash.com/...", "Dark Fantasy", 2250),
                FeedItem("3", "Demon Slayer", "Beautiful anime battles", "https://images.unsplash.com/...", "Adventure", 1820)
            ))
        }

        get("/stories") {
            call.respond(listOf(
                Story("1", "One Piece", "https://images.unsplash.com/..."),
                Story("2", "Naruto", "https://images.unsplash.com/..."),
                Story("3", "JJK", "https://images.unsplash.com/...")
            ))
        }

        get("/channels") {
            call.respond(listOf(
                Channel("anime", "Anime Community", 2100),
                Channel("dubbed", "Dubbed Episodes", 980),
                Channel("manga", "Manga Updates", 450)
            ))
        }

        get("/anime") {
            call.respond(listOf(
                AnimeInfo("1", "One Piece", "Adventure", "Still airing", "5.9"),
                AnimeInfo("2", "Attack on Titan", "Action", "Finished", "9.2"),
                AnimeInfo("3", "Spy x Family", "Comedy", "Airing", "8.8")
            ))
        }
    }
}

@kotlinx.serialization.Serializable
data class FeedItem(
    val id: String,
    val title: String,
    val description: String,
    val imageUrl: String,
    val category: String,
    val likes: Int
)

@kotlinx.serialization.Serializable
data class Story(
    val id: String,
    val title: String,
    val imageUrl: String
)

@kotlinx.serialization.Serializable
data class Channel(
    val id: String,
    val name: String,
    val members: Int
)

@kotlinx.serialization.Serializable
data class AnimeInfo(
    val id: String,
    val title: String,
    val genre: String,
    val status: String,
    val rating: String
)
