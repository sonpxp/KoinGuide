package com.cloudxanh.kointutorial.di

import com.cloudxanh.kointutorial.data.api.ApiService
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit


/**
 * @Created by Sonpxp on 11/1/2022.
 * @Website: Cloudxanh.com
 * @Email: sonpxp@gmail.com
 */

val apiModule = module {
    // single { provideJsonPlaceHolderApi(get()) }

    /**
     * @Koin Constructor DSL
     * @since version 3.2 above
     * */
    singleOf(::provideJsonPlaceHolderApi)
}

private fun provideJsonPlaceHolderApi(retrofit: Retrofit): ApiService {
    return retrofit.create(ApiService::class.java)
}