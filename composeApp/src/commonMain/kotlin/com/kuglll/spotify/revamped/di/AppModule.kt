package com.kuglll.spotify.revamped.di

import com.kuglll.spotify.revamped.data.api.PostService
import com.kuglll.spotify.revamped.data.api.PostServiceImpl
import com.kuglll.spotify.revamped.ui.viewmodels.PostsViewModel
import org.koin.dsl.module

val appModule = module {
    // Services
    single<PostService> { PostServiceImpl() }
    
    // ViewModels
    factory { PostsViewModel(get()) }
} 
