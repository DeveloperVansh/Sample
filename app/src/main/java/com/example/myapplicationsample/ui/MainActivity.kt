package com.example.myapplicationsample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.annotation.BinderThread
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.myapplicationsample.R
import com.example.myapplicationsample.databinding.ActivityMainBinding
import com.example.myapplicationsample.ui.adpater.Adpter
import com.example.myapplicationsample.ui.repo.MainRepostiry
import com.example.myapplicationsample.ui.viewmodel.MainViewModel
import com.example.myapplicationsample.utils.Resource

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var mViewModel: MainViewModel
    val mRepository: MainRepostiry = MainRepostiry()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        mViewModel = MainViewModel(mRepository)

        mViewModel.apiCall(count = 3)

        Observers()
    }

    fun Observers() {
        mViewModel.isRealtime.observe(this) {
            when (it) {
                is Resource.Success -> {
                    binding.rv.apply {
                        this.layoutManager = LinearLayoutManager(this@MainActivity)
                        val adapter = Adpter(it.value.data)
                        this.adapter = adapter
                    }

                }

                is Resource.Loading -> {


                }

                is Resource.Failure -> {



                }


            }
        }
    }
}