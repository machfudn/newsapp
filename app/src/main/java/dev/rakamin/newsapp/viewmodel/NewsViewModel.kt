package dev.rakamin.newsapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.rakamin.newsapp.data.NewsRepository
import dev.rakamin.newsapp.models.Article
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val repo = NewsRepository()

    private val _headline = MutableLiveData<Article>()
    val headline: LiveData<Article> = _headline

    private val _newsList = MutableLiveData<List<Article>>()
    val newsList: LiveData<List<Article>> = _newsList

    init {
        loadNews()
    }

    private fun loadNews() {
        viewModelScope.launch {
            val headlineResp = repo.fetchHeadlines("us")
            _headline.value = headlineResp.articles.first()

            val allNewsResp = repo.fetchEverything("technology", 1)
            _newsList.value = allNewsResp.articles
        }
    }
}
