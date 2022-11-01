package com.cloudxanh.kointutorial.di

import com.cloudxanh.kointutorial.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


/**
 * @Created by Sonpxp on 11/1/2022.
 * @Website: Cloudxanh.com
 * @Email: sonpxp@gmail.com
 */

val retrofitModule = module {
//    single { provideMoshiConverterFactory() }
//    single { provideOkHttpClient() }
//    single { provideRetrofit(get(), get()) }

    /**
     * @Koin Constructor DSL
     * @since version 3.2 above
     * */
    singleOf(::provideMoshiConverterFactory)
    singleOf(::provideOkHttpClient)
    singleOf(::provideRetrofit)
}

private fun provideOkHttpClient(): OkHttpClient {
    return if (BuildConfig.DEBUG) {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    } else OkHttpClient.Builder().build()
}

private fun provideMoshiConverterFactory(): MoshiConverterFactory {
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    return MoshiConverterFactory.create(moshi)
}

private fun provideRetrofit(
    okHttpClient: OkHttpClient,
    moshiConverterFactory: MoshiConverterFactory
): Retrofit {
    return Retrofit.Builder()
        .addConverterFactory(moshiConverterFactory)
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .client(okHttpClient)
        .build()
}