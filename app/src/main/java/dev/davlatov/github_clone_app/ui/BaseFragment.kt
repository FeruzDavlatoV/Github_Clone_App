package dev.davlatov.github_clone_app.ui

import androidx.fragment.app.Fragment
import dev.davlatov.github_clone_app.models.ForYouAndTrendingModel

// this fragment is a base fragment for all fragments
open class BaseFragment : Fragment() {
    protected open fun prepareModelsList(): ArrayList<ForYouAndTrendingModel> {
        val list = ArrayList<ForYouAndTrendingModel>()
        for (i in 1..30) {
            list.add(ForYouAndTrendingModel(null, null))
        }
        return list
    }
}