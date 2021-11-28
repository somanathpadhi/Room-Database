package com.android.roomdatabase

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.android.roomdatabase.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ContactsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        lifecycleScope.launchWhenCreated {
            viewModel.insertContact(Contact(1, "s", 20, "1234567890"))
        }
        binding.getAllContacts.setOnClickListener {
            getAllContacts()
        }
    }

    private fun getAllContacts() {
        lifecycleScope.launchWhenCreated {
            viewModel.contactsLiveData.collect {
                Log.d("DB", it.toString())
            }
        }
    }
}