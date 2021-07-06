package com.example.unittest_sample.ui.main

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ApplicationProvider
import androidx.test.core.content.pm.ApplicationInfoBuilder
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.unittest_sample.data.DataService
import com.example.unittest_sample.getOrAwaitValue
import com.example.unittest_sample.model.User
import junit.framework.TestCase
import org.junit.Assert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewModelTest : TestCase() {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    public override fun setUp() {
        super.setUp()
        val context = ApplicationProvider.getApplicationContext<Context>()
        val dataService = DataService(context)
        viewModel = MainViewModel(dataService)
    }

    @Test
    fun testMainViewModel() {
        checkAddUser()
        checkAddUserAgeValidation()
        checkAddUserNameValidation()
        checkRemoveUser()
        checkRecordCheckPositive()
        checkRecordCheckNegative()
        checkGetAll()
    }

    private fun checkAddUser() {
        viewModel.addUser(User(200, "Can", "Gür", 29))
        var addUserResult = viewModel.addUserResult.getOrAwaitValue {

        }
        assertTrue(addUserResult!!.message, addUserResult.success)
    }

    private fun checkAddUserAgeValidation() {
        viewModel.addUser(User(42, "Hüseyin", "Küçük", 10))
        var addUserResult = viewModel.addUserResult.getOrAwaitValue {

        }
        assertTrue("PROBLEM----" + addUserResult!!.message, !addUserResult.success)
    }

    private fun checkAddUserNameValidation() {
        viewModel.addUser(User(55, "T", "Ertürk", 29))
        var addUserResult = viewModel.addUserResult.getOrAwaitValue {

        }
        assertTrue("PROBLEM----" + addUserResult!!.message, !addUserResult.success)
    }

    private fun checkRemoveUser() {
        viewModel.addUser(User(201, "Gökhan", "Öztürk", 30))
        viewModel.deleteUser(User(201, "Gökhan", "Öztürk", 30))
        var deleteUserResult = viewModel.deleteUserResult.getOrAwaitValue {

        }
        assertTrue(deleteUserResult!!.message, deleteUserResult.success)

    }

    private fun checkRecordCheckPositive() {
        viewModel.addUser(User(300, "Emre", "Alp", 30))
        viewModel.recordCheck(300)
        var recordCheckResult = viewModel.recordCheckResult.getOrAwaitValue {

        }
        assertTrue(recordCheckResult!!.message, recordCheckResult.success)

    }

    private fun checkRecordCheckNegative() {
        viewModel.recordCheck(999999)
        var recordCheckResult = viewModel.recordCheckResult.getOrAwaitValue {

        }
        assertTrue("PROBLEM----" + recordCheckResult!!.message, !recordCheckResult.success)
    }

    private fun checkGetAll() {
        viewModel.getAll()
        var recordCheckResult = viewModel.getAllResult.getOrAwaitValue {

        }
        assertNotNull("getAll Problem", recordCheckResult)
    }
}



