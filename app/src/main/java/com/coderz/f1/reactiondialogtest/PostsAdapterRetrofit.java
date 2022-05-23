package com.coderz.f1.reactiondialogtest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.coderz.f1.reactiondialogtest.databinding.ItemViewBinding;

import java.util.List;

public class PostsAdapterRetrofit extends RecyclerView.Adapter<PostsAdapterRetrofit.ViewHolder> implements ReactionsDialog.ReactionListener{
    private final Context context;
    List<Post> items;

    public PostsAdapterRetrofit(Context context, List<Post> items) {
        this.items = items;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public ImageView imageView;
        public ViewHolder(ItemViewBinding binding) {
            super(binding.getRoot());
            textView = binding.textView;
            imageView = binding.imageView;
        }
    }

    private void getReactionDialog(FragmentManager fragmentManager, int itemPosition){
        ReactionsDialog reactionsDialog = new ReactionsDialog(this,itemPosition);
        reactionsDialog.show(fragmentManager, reactionsDialog.getClass().getSimpleName());
    }

    @Override
    public void onReactionSelected(int reactionType, int itemPosition) {
        Post post;
        switch (reactionType) {
            case 0:
                Toast.makeText(context, "You liked the post.", Toast.LENGTH_SHORT).show();
                post = new Post(items.get(itemPosition).getMessage(),LikeValue.LIKE);
                items.set(itemPosition,post);
                break;
            case 1:
                Toast.makeText(context, "You loved the post.", Toast.LENGTH_SHORT).show();
                post = new Post(items.get(itemPosition).getMessage(),LikeValue.LOVE);
                items.set(itemPosition,post);
                break;
            case 2:
                Toast.makeText(context, "You hahahed the post.", Toast.LENGTH_SHORT).show();
                post = new Post(items.get(itemPosition).getMessage(),LikeValue.HAHA);
                items.set(itemPosition,post);
                break;
            case 3:
                Toast.makeText(context, "You closed your eye to the post.", Toast.LENGTH_SHORT).show();
                post = new Post(items.get(itemPosition).getMessage(),LikeValue.EYES_CLOSED);
                items.set(itemPosition,post);
                break;
            case 4:
                Toast.makeText(context, "You wowed the post.", Toast.LENGTH_SHORT).show();
                post = new Post(items.get(itemPosition).getMessage(),LikeValue.WOW);
                items.set(itemPosition,post);
                break;
            default:
                post = new Post(items.get(itemPosition).getMessage(),LikeValue.LIKE);
                items.set(itemPosition,post);
        }
        notifyItemChanged(itemPosition);
    }

    @NonNull
    @Override
    public PostsAdapterRetrofit.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        @NonNull ItemViewBinding binding = ItemViewBinding.inflate(LayoutInflater.from(context),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsAdapterRetrofit.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        LikeValue value = items.get(position).getLikeValue();
        switch (value){
            case LIKE:
            case DEFAULT:
                holder.imageView.setImageResource(R.drawable.ic_like);
                break;
            case WOW:
                holder.imageView.setImageResource(R.drawable.wowreaction);
                break;
            case EYES_CLOSED:
                holder.imageView.setImageResource(R.drawable.ic_eyeclosereaction);
                break;
            case HAHA:
                holder.imageView.setImageResource(R.drawable.ic_haha);
                break;
            case LOVE:
                holder.imageView.setImageResource(R.drawable.ic_love);
        }
        holder.textView.setText(items.get(position).getMessage());
        holder.imageView.setClickable(true);
        holder.imageView.setOnLongClickListener(view -> {
//            selectedPosition = position;
            getReactionDialog(((AppCompatActivity)context).getSupportFragmentManager(),position);
            return false;
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}