package com.example.unittest_sample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.unittest_sample.data.DataService
import com.example.unittest_sample.model.User
import com.example.unittest_sample.model.Result

class MainViewModel(var dataService: DataService) : ViewModel() {

    //variables
    var _addUserResult = MutableLiveData<Result?>()
    val addUserResult: LiveData<Result?> = _addUserResult

    var _deleteUserResult = MutableLiveData<Result?>()
    val deleteUserResult: LiveData<Result?> = _deleteUserResult

    var _recordCheckResult = MutableLiveData<Result?>()
    val recordCheckResult: LiveData<Result?> = _recordCheckResult

    var _getAllResult= MutableLiveData<ArrayList<User>?>()
    val getAllResult: LiveData<ArrayList<User>?> = _getAllResult


    ///functions

    fun addUser(user: User) {
        _addUserResult.value = dataService.addUser(user)
    }

    fun deleteUser(user: User) {
        _deleteUserResult.postValue(dataService.deleteUser(user))
    }

    fun recordCheck(userId: Int) {
        _recordCheckResult.postValue(dataService.recordCheck(userId))
    }

    fun getAll() {
        _getAllResult.postValue(dataService.getAll())
    }


}