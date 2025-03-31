package com.kuglll.kmm.example.data.api

import com.kuglll.kmm.example.data.model.Post
import io.ktor.client.call.*
import io.ktor.client.request.*

class PostServiceImpl : PostService {
    private val baseUrl = "https://jsonplaceholder.typicode.com"

    override suspend fun getPost(id: Int): Post {
        return KtorClient.client.get("$baseUrl/posts/$id").body()
    }

    override suspend fun getAllPosts(): List<Post> {
        return KtorClient.client.get("$baseUrl/posts").body()
    }
} 
