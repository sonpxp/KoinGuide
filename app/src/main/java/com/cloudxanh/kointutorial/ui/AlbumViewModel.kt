package com.cloudxanh.kointutorial.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cloudxanh.kointutorial.data.model.Album
import com.cloudxanh.kointutorial.data.repository.AlbumRepository
import com.cloudxanh.kointutorial.utils.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


/**
 * @Created by Sonpxp on 11/1/2022.
 * @Website: Cloudxanh.com
 * @Email: sonpxp@gmail.com
 */
class AlbumViewModel(
    private val albumRepository: AlbumRepository
) : ViewModel() {

    private val _albums = MutableStateFlow<Resource<List<Album>>>(Resource.loading(emptyList()))
    val books = _albums.asStateFlow()

    init {
        fetchData()
    }

    private fun fetchData() {
        viewModelScope.launch {
            try {
                albumRepository.getAllAlbums().let {
                    if (it.isSuccessful) {
                        _albums.value = Resource.success(it.body())
                    } else {
                        _albums.value = Resource.error(it.errorBody().toString(), null)
                    }
                }
                //_albums.value = Resource.error("No internet connection", null)
            } catch (e: Exception) {
                _albums.value = Resource.error(e.toString(), null)
            }
        }
    }
}
