package com.kuglll.kmm.example.data.api

import com.kuglll.kmm.example.data.model.Post

interface PostService {
    suspend fun getPost(id: Int): Post
    suspend fun getAllPosts(): List<Post>
} 