package com.example.labexercise5


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import my.edu.tarc.exercise5.CountViewModel


class MainActivity : AppCompatActivity() {

    lateinit var countVM: CountViewModel
    lateinit var sharePre: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        countVM = ViewModelProviders.of(this).get(CountViewModel::class.java)
        sharePre = getPreferences(Context.MODE_PRIVATE)


        imageViewLike.setOnClickListener {
            countVM.plusLike()
            textViewLike.text = countVM.countLike.toString()
        }


        imageViewDislike.setOnClickListener {
            countVM.plusDislike()
            textViewDislike.text = countVM.countDislike.toString()
        }
    }

    override fun onStart() {
        Log.d("MainActivity" , "onStart")

        super.onStart()
    }

    override fun onResume() {
        Log.d("MainActivity" , "onResume")

        val like = sharePre.getInt(getString(R.string.like), 0)
        val dislike = sharePre.getInt(getString(R.string.dislike), 0)

        countVM.countLike = like
        countVM.countDislike = dislike
        textViewLike.text = countVM.countLike.toString()
        textViewDislike.text = countVM.countDislike.toString()

        super.onResume()
    }

    override fun onPause() {
        Log.d("MainActivity" , "onPause")

        with(sharePre.edit()){
            putInt(getString(R.string.like), countVM.countLike)
            putInt(getString(R.string.dislike), countVM.countDislike)
            commit()
        }

        super.onPause()

    }

    override fun onStop() {
        Log.d("MainActivity" , "onStop")

        super.onStop()
    }

    override fun onDestroy() {
        Log.d("MainActivity" , "onDestroy")

        super.onDestroy()
    }
}
