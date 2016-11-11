package com.waterislandpuzzle;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import java.util.HashSet;
import java.util.Set;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match

    private GridView earthView;
    private OnFragmentInteractionListener mListener;
    private PuzzleEngine puzzleEngine;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        return new HomeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        earthView = (GridView) view.findViewById(R.id.earthView);
        final Button solvePuzzleBtn = (Button) view.findViewById(R.id.solvePuzzleBtn);
        final Button generatePuzzleBtn = (Button) view.findViewById(R.id.generatePuzzleBtn);
        puzzleEngine = new PuzzleEngine(getActivity());


        generatePuzzleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puzzleEngine.generatePuzzle();
                earthView.setAdapter(new EarthFillAdapter((getActivity())));
                solvePuzzleBtn.setVisibility(View.VISIBLE);
                generatePuzzleBtn.setVisibility(View.INVISIBLE);
            }
        });
        solvePuzzleBtn.setVisibility(View.INVISIBLE);
        solvePuzzleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                puzzleEngine.solvePuzzle();
                earthView.setAdapter(new EarthFillAdapter((getActivity())));
                generatePuzzleBtn.setVisibility(View.VISIBLE);
                solvePuzzleBtn.setVisibility(View.INVISIBLE);
            }
        });


        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}
