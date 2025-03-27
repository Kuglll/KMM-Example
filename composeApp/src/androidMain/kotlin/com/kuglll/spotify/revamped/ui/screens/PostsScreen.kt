package com.kuglll.spotify.revamped.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kuglll.spotify.revamped.data.api.PostServiceImpl
import com.kuglll.spotify.revamped.data.model.Post
import com.kuglll.spotify.revamped.ui.components.PostItem

@Composable
fun PostsScreen() {
    var posts by remember { mutableStateOf<List<Post>>(emptyList()) }
    var isLoading by remember { mutableStateOf(false) }
    var error by remember { mutableStateOf<String?>(null) }
    
    val postService = remember { PostServiceImpl() }

    LaunchedEffect(Unit) {
        isLoading = true
        try {
            posts = postService.getAllPosts()
        } catch (e: Exception) {
            error = e.message
        } finally {
            isLoading = false
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        when {
            isLoading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
            }
            error != null -> {
                Text(
                    text = "Error: $error",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp)
                )
            }
            else -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    items(posts) { post ->
                        PostItem(post = post)
                    }
                }
            }
        }
    }
} 