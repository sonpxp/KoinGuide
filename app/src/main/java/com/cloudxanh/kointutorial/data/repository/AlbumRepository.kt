package com.cloudxanh.kointutorial.data.repository

import com.cloudxanh.kointutorial.data.api.ApiService


/**
 * @Created by Sonpxp on 11/1/2022.
 * @Website: Cloudxanh.com
 * @Email: sonpxp@gmail.com
 */
class AlbumRepository(private val apiService: ApiService) {

    suspend fun getAllAlbums() = apiService.getAlbums()
}