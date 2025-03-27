package com.kuglll.spotify.revamped.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuglll.spotify.revamped.data.api.PostService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostsViewModel(
    private val postService: PostService,
) : ViewModel() {
    private val _state = MutableStateFlow<PostsState>(PostsState.Loading)
    val state: StateFlow<PostsState> = _state.asStateFlow()

    init {
        fetchPosts()
    }

    private fun fetchPosts() {
        viewModelScope.launch {
            _state.value = PostsState.Loading
            try {
                val posts = postService.getAllPosts()
                _state.value = PostsState.Success(posts = posts)
            } catch (e: Exception) {
                _state.value = PostsState.Error(message = e.message ?: "Unknown error occurred")
            }
        }
    }
} 