package com.kuglll.kmm.example.ui.viewmodels

import com.kuglll.kmm.example.data.model.Post

sealed class PostsState {
    data object Loading : PostsState()
    data class Error(val message: String) : PostsState()
    data class Success(val posts: List<Post>) : PostsState()
} 