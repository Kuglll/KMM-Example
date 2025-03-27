package com.kuglll.spotify.revamped.data.api

import com.kuglll.spotify.revamped.data.model.Post

interface PostService {
    suspend fun getPost(id: Int): Post
    suspend fun getAllPosts(): List<Post>
} 