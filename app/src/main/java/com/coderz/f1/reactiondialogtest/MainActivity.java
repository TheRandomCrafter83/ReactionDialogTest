package com.coderz.f1.reactiondialogtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.coderz.f1.reactiondialogtest.databinding.ActivityMainBinding;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        List<Post> items = Arrays.asList(new Post("Hello World",LikeValue.DEFAULT), new Post("This is a test",LikeValue.DEFAULT));
        binding.recycler.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        binding.recycler.setAdapter(new PostsAdapterRetrofit(this,items));
    }
}