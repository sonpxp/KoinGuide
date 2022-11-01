package com.cloudxanh.kointutorial.di

import com.cloudxanh.kointutorial.ui.AlbumViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module


/**
 * @Created by Sonpxp on 11/1/2022.
 * @Website: Cloudxanh.com
 * @Email: sonpxp@gmail.com
 */

val viewModelModule = module {
//    viewModel {
//        AlbumViewModel(get())
//    }

    /**
     * @Koin Constructor DSL
     * @since version 3.2 above
     * */
    viewModelOf(::AlbumViewModel)
}