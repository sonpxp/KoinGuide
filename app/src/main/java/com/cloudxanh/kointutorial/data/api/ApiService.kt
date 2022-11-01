package com.cloudxanh.kointutorial.data.api

import com.cloudxanh.kointutorial.data.model.Album
import retrofit2.Response
import retrofit2.http.*


/**
 * @Created by Sonpxp on 11/1/2022.
 * @Website: Cloudxanh.com
 * @Email: sonpxp@gmail.com
 */
interface ApiService {

    // https://jsonplaceholder.typicode.com/albums

    @Headers("Accept: application/json")
    @GET("albums")
    suspend fun getAlbums(): Response<List<Album>>
}
