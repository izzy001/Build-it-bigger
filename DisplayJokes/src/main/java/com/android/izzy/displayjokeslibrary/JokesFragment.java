package com.android.izzy.displayjokeslibrary;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Objects;

public class JokesFragment extends Fragment {

    public JokesFragment() {

    }

    @TargetApi(Build.VERSION_CODES.KITKAT)

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_jokes, container, false);
        Intent intent = Objects.requireNonNull(getActivity()).getIntent();
        String joke =intent.getStringExtra(JokesActivity.JOKE_KEY);
        TextView jokeTextView = view.findViewById(R.id.tv_jokes);

        if (joke != null && joke.length() != 0) {
            jokeTextView.setText(joke);
        }
        return view;
    }
}
