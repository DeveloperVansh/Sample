package com.example.myapplicationsample.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.myapplicationsample.ui.repo.BaseRepo

abstract class BaseViewModel(private val repository: BaseRepo) : ViewModel()