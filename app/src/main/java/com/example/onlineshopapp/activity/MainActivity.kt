package com.example.onlineshopapp.activity

import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bumptech.glide.Glide
import com.example.onlineshopapp.databinding.ActivityMainBinding
import com.example.onlineshopapp.ui.theme.onlineShopAppTheme
import com.example.onlineshopapp.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initBanner()
    }

    private fun initBanner() {
        binding.progressBarBanner.visibility = View.VISIBLE

        viewModel.loadBanner().observeForever {
            Glide
                .with(binding.banner.context)
                .load(it[0].url)
                .into(binding.banner)

            binding.progressBarBanner.visibility = View.GONE
        }
        viewModel.loadBanner()
    }
}

@Composable
fun greeting(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun greetingPreview() {
    onlineShopAppTheme {
        greeting("Android")
    }
}
