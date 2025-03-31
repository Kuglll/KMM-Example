package com.kuglll.kmm.example.di

import com.kuglll.kmm.example.data.api.PostService
import com.kuglll.kmm.example.data.api.PostServiceImpl
import com.kuglll.kmm.example.ui.viewmodels.PostsViewModel
import org.koin.dsl.module

val appModule = module {
    // Services
    single<PostService> { PostServiceImpl() }
    
    // ViewModels
    factory { PostsViewModel(get()) }
} 
