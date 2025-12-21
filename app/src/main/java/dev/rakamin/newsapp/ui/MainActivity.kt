package dev.rakamin.newsapp.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import dev.rakamin.newsapp.R
import dev.rakamin.newsapp.databinding.ActivityMainBinding
import dev.rakamin.newsapp.viewmodel.NewsViewModel
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var adapter: NewsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this)[NewsViewModel::class.java]

        setupRecycler()
        observeData()
    }

    private fun setupRecycler() {
        adapter = NewsAdapter { article ->
            article.url?.let {
                startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(it)))
            }
        }

        binding.rvNews.layoutManager = LinearLayoutManager(this)
        binding.rvNews.adapter = adapter
    }

    private fun observeData() {
        viewModel.headline.observe(this) { article ->
            // Akses view di headline
            val tvHeadlineTitle = binding.cardHeadline.findViewById<android.widget.TextView>(R.id.tvHeadlineTitle)
            val ivHeadline = binding.cardHeadline.findViewById<android.widget.ImageView>(R.id.ivHeadline)
            val tvHeadlineSource = binding.cardHeadline.findViewById<android.widget.TextView>(R.id.tvHeadlineSource)
            val tvHeadlineDate = binding.cardHeadline.findViewById<android.widget.TextView>(R.id.tvHeadlineDate)

            tvHeadlineTitle.text = article.title

            // Load gambar headline
            ivHeadline.load(article.urlToImage) {
                placeholder(R.drawable.ic_image_placeholder)
                error(R.drawable.ic_image_placeholder)
            }

            // Set source
            tvHeadlineSource.text = article.source?.name ?: "Unknown Source"

            // Format tanggal
            article.publishedAt?.let { dateStr ->
                tvHeadlineDate.text = formatDate(dateStr)
            } ?: run {
                tvHeadlineDate.text = ""
            }

            // Click listener untuk headline
            binding.cardHeadline.setOnClickListener {
                article.url?.let { url ->
                    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
                }
            }
        }

        viewModel.newsList.observe(this) { articles ->
            adapter.submitList(articles)
        }
    }

    private fun formatDate(dateString: String): String {
        return try {
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            val outputFormat = SimpleDateFormat("dd MMM, yyyy", Locale.getDefault())
            val date = inputFormat.parse(dateString)
            date?.let { outputFormat.format(it) } ?: dateString.take(10)
        } catch (e: Exception) {
            dateString.take(10)
        }
    }
}