package com.cloudxanh.kointutorial.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cloudxanh.kointutorial.data.model.Album
import com.cloudxanh.kointutorial.databinding.ActivityMainBinding
import com.cloudxanh.kointutorial.utils.Status
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val albumViewModel: AlbumViewModel by viewModel()
    private lateinit var adapter: AlbumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObserver()
    }

    private fun setupObserver() {
        lifecycleScope.launch {
            albumViewModel.books
                .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
                .collect() {
                    when (it.status) {
                        Status.SUCCESS -> {
                            binding.progressBar.visibility = View.GONE
                            it.data?.let { albums ->
                                renderList(albums)
                                binding.recyclerView.visibility = View.VISIBLE
                            }
                        }
                        Status.LOADING -> {
                            binding.progressBar.visibility = View.VISIBLE
                            binding.recyclerView.visibility = View.GONE
                        }
                        Status.ERROR -> {
                            //Handle Error
                            binding.progressBar.visibility = View.GONE
                            Toast.makeText(this@MainActivity, it.message, Toast.LENGTH_LONG).show()
                        }
                    }
                }
        }
    }

    private fun renderList(albums: List<Album>) {
        with(binding) {
            adapter = AlbumAdapter()
            adapter.submitList(albums)
            recyclerView.layoutManager =
                LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            recyclerView.adapter = adapter
        }
    }
}