package com.kuglll.spotify.revamped.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kuglll.spotify.revamped.data.api.PostServiceImpl
import com.kuglll.spotify.revamped.ui.components.PostItem
import com.kuglll.spotify.revamped.ui.viewmodels.PostsState
import com.kuglll.spotify.revamped.ui.viewmodels.PostsViewModel

@Composable
fun PostsScreen(
    modifier: Modifier = Modifier,
    viewModel: PostsViewModel = viewModel { PostsViewModel(PostServiceImpl()) },
) {

    val state by viewModel.state.collectAsState()

    Box(modifier = modifier.fillMaxSize()) {
        when (state) {
            is PostsState.Loading -> {
                CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center),
                )
            }
            is PostsState.Error -> {
                Text(
                    text = "Error: ${(state as PostsState.Error).message}",
                    color = MaterialTheme.colorScheme.error,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(16.dp),
                )
            }
            is PostsState.Success -> {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(16.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    items((state as PostsState.Success).posts) { post ->
                        PostItem(post = post)
                    }
                }
            }
        }
    }
} 
