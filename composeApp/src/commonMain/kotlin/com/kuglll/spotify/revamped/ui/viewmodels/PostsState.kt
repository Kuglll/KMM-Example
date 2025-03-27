package com.kuglll.spotify.revamped.ui.viewmodels

import com.kuglll.spotify.revamped.data.model.Post

sealed class PostsState {
    data object Loading : PostsState()
    data class Error(val message: String) : PostsState()
    data class Success(val posts: List<Post>) : PostsState()
} 