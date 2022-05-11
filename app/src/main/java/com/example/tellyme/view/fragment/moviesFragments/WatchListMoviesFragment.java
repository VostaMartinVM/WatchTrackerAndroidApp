package com.example.tellyme.view.fragment.moviesFragments;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tellyme.R;
import com.example.tellyme.adapters.ListsAdapter;
import com.example.tellyme.adapters.MovieWatchListListAdapter;
import com.example.tellyme.model.DummyData;
import com.example.tellyme.view.activity.SpecificMovie;
import com.example.tellyme.view.activity.SpecificShow;
import com.example.tellyme.view.fragment.listsFragments.SpecificListFragment;
import com.example.tellyme.viewModel.MoviesViewModels.WatchListMoviesViewModel;

import java.util.ArrayList;

public class WatchListMoviesFragment extends Fragment {

    private ArrayList<DummyData> dummyData = new ArrayList<>();
    private MovieWatchListListAdapter movieWatchListListAdapter;
    private MovieWatchListListAdapter.RecyclerViewOnClickListener listener;
    private View view;


    public static WatchListMoviesFragment newInstance() {
        return new WatchListMoviesFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        dummyData.add(new DummyData("StarWars", R.mipmap.lists_background));
        dummyData.add(new DummyData("F&F", R.mipmap.lists_background));
        dummyData.add(new DummyData("fakt uz nevim", R.mipmap.lists_background));

        view = inflater.inflate(R.layout.watch_list_movies_fragment, container, false);
        setOnClickListener();
        RecyclerView recyclerView = view.findViewById(R.id.watch_list_movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        movieWatchListListAdapter = new MovieWatchListListAdapter(dummyData, listener);
        recyclerView.setAdapter(movieWatchListListAdapter);

        return view;
    }


    private void setOnClickListener(){
        listener = new MovieWatchListListAdapter.RecyclerViewOnClickListener() {
            @Override
            public void onClick(View view, int position) {
                Intent i = new Intent(getActivity(), SpecificMovie.class);
                startActivity(i);
            }
        };
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

}