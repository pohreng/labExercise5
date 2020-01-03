package my.edu.tarc.exercise5

import android.util.Log
import androidx.lifecycle.ViewModel


class CountViewModel: ViewModel() {
    var like: Int = 0
    var dislike: Int = 0

    init {
        Log.d("ViewModel", "ViewModel created")
    }
    fun plusLike(){
        like++
    }
    fun plusDislike() {
        dislike++
    }
    override fun onCleared() {
        Log.d("ViewModel", "ViewModel destroyed")
        super.onCleared()
    }
}