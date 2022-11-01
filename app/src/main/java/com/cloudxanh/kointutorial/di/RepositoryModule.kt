package com.cloudxanh.kointutorial.di

import com.cloudxanh.kointutorial.data.repository.AlbumRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module


/**
 * @Created by Sonpxp on 11/1/2022.
 * @Website: Cloudxanh.com
 * @Email: sonpxp@gmail.com
 */

val repositoryModule = module {
//    single {
//        AlbumRepository(get())
//    }

    /**
     * @Koin Constructor DSL
     * @since version 3.2 above
     * */
    singleOf(::AlbumRepository)
}