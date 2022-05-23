package com.coderz.f1.reactiondialogtest;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;

public class ReactionsDialog extends DialogFragment implements View.OnClickListener{
    int itemPosition;

    public ReactionsDialog(ReactionListener listener, int itemPosition){
        this.listener = listener;
        this.itemPosition = itemPosition;
    }

    public interface ReactionListener {
        default void onReactionSelected(int reactionType, int itemPosition){}
        default void onReactionSelected(int reactionType){}
    }

    ReactionListener listener;

    View view;
    ImageView like, love, haha, glimpse, wow;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.dialog_reactions, container, false);
        initializeComponents();
        return view;
    }

    private void initializeComponents() {
        if (getView() == null)return;
        like = getView().findViewById(R.id.likeReaction);
        love = getView().findViewById(R.id.loveReaction);
        haha = getView().findViewById(R.id.hahaReaction);
        glimpse = getView().findViewById(R.id.eyeCloseReaction);
        wow = getView().findViewById(R.id.wowReaction);

        //Set click listeners
        like.setOnClickListener(this);
        love.setOnClickListener(this);
        haha.setOnClickListener(this);
        glimpse.setOnClickListener(this);
        wow.setOnClickListener(this);
    }

    @Nullable
    @Override
    public View getView() {
        return view;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.likeReaction:
                listener.onReactionSelected(0,itemPosition);
                getDialog().dismiss();
                break;
            case R.id.loveReaction:
                listener.onReactionSelected(1,itemPosition);
                getDialog().dismiss();
                break;
            case R.id.hahaReaction:
                listener.onReactionSelected(2,itemPosition);
                getDialog().dismiss();
                break;
            case R.id.eyeCloseReaction:
                listener.onReactionSelected(3,itemPosition);
                getDialog().dismiss();
                break;
            case R.id.wowReaction:
                listener.onReactionSelected(4,itemPosition);
                getDialog().dismiss();
                break;
        }
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void setupDialog(@NonNull Dialog dialog, int style) {
        super.setupDialog(dialog, style);
        WindowManager.LayoutParams manager = new WindowManager.LayoutParams();
        manager.width = WindowManager.LayoutParams.MATCH_PARENT;
        manager.height = WindowManager.LayoutParams.WRAP_CONTENT;
        manager.dimAmount = 0.0f;
        dialog.getWindow().getDecorView().setBackground(ContextCompat.getDrawable(requireContext(),android.R.color.transparent));
        dialog.setCanceledOnTouchOutside(true);
        dialog.onBackPressed();
    }

}