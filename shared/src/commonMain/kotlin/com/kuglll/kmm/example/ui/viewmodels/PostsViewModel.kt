package com.kuglll.kmm.example.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kuglll.kmm.example.data.api.PostService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

//TODO: We can move that to android main, since we won't reuse this in ios

//TODO: Setup kmmbridge to publish to a private github repo
//TODO: Set up GitHub authentication in Xcode to access the private repository (using Github PAT)
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
            _state.update { PostsState.Loading }
            try {
                val posts = postService.getAllPosts()
                _state.update { PostsState.Success(posts = posts) }
            } catch (e: Exception) {
                _state.update { PostsState.Error(message = e.message ?: "Unknown error occurred") }
            }
        }
    }
} 
