package dev.davlatov.github_clone_app.ui.home.details.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.davlatov.github_clone_app.models.repositories_search_response.RepositoriesResponse
import dev.davlatov.github_clone_app.models.users_search_response.UsersResponse
import dev.davlatov.github_clone_app.repositories.MainRepository
import dev.davlatov.github_clone_app.utils.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: MainRepository) : ViewModel() {
    companion object {
        private val TAG: String = SearchViewModel::class.java.simpleName.toString()
    }

    val usersResponse =
        MutableLiveData<Resource<UsersResponse>>()

    val repositoriesResponse =
        MutableLiveData<Resource<RepositoriesResponse>>()

    fun getRepositories(query: String) {
        viewModelScope.launch {
            repositoriesResponse.postValue(Resource.loading(null))
            try {
                val repositories = repository.getRepositories(query)
                repositoriesResponse.postValue(Resource.success(repositories))
            } catch (exception: Exception) {
                repositoriesResponse.postValue(Resource.error("$exception", null))
            }
        }
    }

    fun getUsers(query: String) {
        viewModelScope.launch {
            usersResponse.postValue(Resource.loading(null))
            try {
                val users = repository.getUsers(query)
                usersResponse.postValue(Resource.success(users))
            } catch (exception: Exception) {
                usersResponse.postValue(Resource.error("$exception", null))
            }
        }
    }
}
