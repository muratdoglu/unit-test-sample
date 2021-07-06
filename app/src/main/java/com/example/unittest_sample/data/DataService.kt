package com.example.unittest_sample.data

import android.content.Context
import com.example.unittest_sample.model.Result
import com.example.unittest_sample.model.User

class DataService(context: Context) {
    var users: ArrayList<User> = arrayListOf(User(1, "Murat", "Değirmencioğlu", 28))

    fun addUser(user: User): Result {
        var result = Result()
        result.message = "Success"
        result.success = true
        if (user.age < 18) {
            result.message = "User can't be under than 18 age"
            result.success = false
        }
        if (user.name.length < 3) {
            result.message = "User name length can't be under than 3"
            result.success = false
        }

        if (user.name.length < 3) {
            result.message = "User name length can't be under than 3"
            result.success = false
        }
        if (result.success) {
            users.add(user)
        }
        return result
    }

    fun deleteUser(user: User): Result {
        var result = Result()
        result.message = "Success"
        result.success = true
        if (!users.remove(user)) {
            result.message = "User not found"
            result.success = false
        }
        return result
    }

    fun recordCheck(id: Int): Result {
        var result = Result()
        result.message = "Success"
        result.success = true
        var foundList = users.filter { it.id == id }
        if (foundList.isEmpty()) {
            result.message = "Not Found"
            result.success = false
        }
        return result
    }

    fun getAll(): ArrayList<User>? {
        return if (users.size > 0) {
            users
        } else null
    }


}