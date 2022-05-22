package com.coderz.f1.reactiondialogtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coderz.f1.reactiondialogtest.databinding.ItemViewBinding;

import java.util.List;

public class PostsAdapterRetrofit extends RecyclerView.Adapter<PostsAdapterRetrofit.ViewHolder> implements ReactionsDialog.ReactionListener{
    private final Context context;

    List<String> items;

    public PostsAdapterRetrofit(Context context, List<String> items) {
        this.items = items;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public Button button;
        public ViewHolder(ItemViewBinding binding) {
            super(binding.getRoot());
            button = binding.button;
        }
    }

    private void getReactionDialog(FragmentManager fragmentManager){
        ReactionsDialog reactionsDialog = new ReactionsDialog(this);
        reactionsDialog.show(fragmentManager, reactionsDialog.getClass().getSimpleName());
    }

    @Override
    public void onReactionSelected(int reactionType) {
        switch (reactionType) {
            case 0:
                Toast.makeText(context, "You liked the post.", Toast.LENGTH_SHORT).show();
                break;
            case 1:
                Toast.makeText(context, "You loved the post.", Toast.LENGTH_SHORT).show();
                break;
            case 2:
                Toast.makeText(context, "You hahahed the post.", Toast.LENGTH_SHORT).show();
                break;
            case 3:
                Toast.makeText(context, "You closed your eye to the post.", Toast.LENGTH_SHORT).show();
                break;
            case 4:
                Toast.makeText(context, "You wowed the post.", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @NonNull
    @Override
    public PostsAdapterRetrofit.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @NonNull ItemViewBinding binding = ItemViewBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapterRetrofit.ViewHolder holder, int position) {
        holder.button.setOnLongClickListener(view -> {
            getReactionDialog(((AppCompatActivity)context).getSupportFragmentManager());
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}