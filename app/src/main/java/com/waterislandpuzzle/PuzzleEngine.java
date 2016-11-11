package com.waterislandpuzzle;

import android.content.Context;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by hp on 11/11/2016.
 */
public class PuzzleEngine {
    Context context;
    Set<String> latestListOfIslands = null;
    Set<String> previousListOfIslands = null;
    int[][] earthMatrix;;
    int latestNumberOfSubIsland=0,previousNumberOfSubIsland=0;
    public PuzzleEngine(Context context){
        this.context=context;
    }

    // A function to check if a given cell (row, col) can
    // be included in DFS
    boolean isIncluded(int matrix[][], int row, int col,
                   boolean visited[][])
    {
        // row number is in range, column number is in range
        // and value is 1 and not yet visited
        return (row >= 0) && (row < Constants.ROW) &&
                (col >= 0) && (col < Constants.COL) &&
                (matrix[row][col]==1 && !visited[row][col]);
    }

    // A utility function to do DFS for a 2D boolean matrix.
    // It only considers the 4 neighbors as adjacent vertices
    void DFS(int matrix[][], int row, int col, boolean visited[][])
    {


        latestNumberOfSubIsland++;
        // Mark this cell as visited
        visited[row][col] = true;

        // Recur for all connected neighbours
        for (int k = 0; k < Constants.NEIGH_N; ++k){
            latestListOfIslands.add(row+"-"+col);
            if (isIncluded(matrix, row + Constants.ROW_N[k], col + Constants.COL_N[k], visited) ) {
                //used recursion instead of stack
                DFS(matrix, row + Constants.ROW_N[k], col + Constants.COL_N[k], visited);
            }
        }

    }

    // The main function that returns count of islands in a given
    //  boolean 2D matrix

    private ArrayList<Set<String>>listOfLargestIslands ;
    void searchLargestIsland(int matrix[][])
    {
        // Make a bool array to mark visited cells.
        // Initially all cells are unvisited
        boolean visited[][] = new boolean[Constants.ROW][Constants.COL];

        listOfLargestIslands = new ArrayList<>();
        // Initialize count as 0 and travese through the all cells
        // of given matrix
        for (int i = 0; i < Constants.ROW; ++i)
            for (int j = 0; j < Constants.COL; ++j)
                if (matrix[i][j]==1 && !visited[i][j]) // If a cell with
                {                                 // value 1 is not
                    // visited yet, then new island found, Visit all
                    // cells in this island and increment island count
                    DFS(matrix, i, j, visited);
                    Set<String> tempLatestListOfIslands = new HashSet<>() ;
                    if (latestNumberOfSubIsland > previousNumberOfSubIsland) {
                        tempLatestListOfIslands.addAll(latestListOfIslands);
                        previousListOfIslands.clear();
                        previousListOfIslands.addAll(latestListOfIslands);
                        if (listOfLargestIslands!=null){
                            listOfLargestIslands.clear();

                        }
                        listOfLargestIslands.add(tempLatestListOfIslands);
                        previousNumberOfSubIsland = latestNumberOfSubIsland;

                    }else if (latestNumberOfSubIsland== previousNumberOfSubIsland) {
                        tempLatestListOfIslands.addAll(latestListOfIslands);
                        listOfLargestIslands.add(tempLatestListOfIslands);
                        previousNumberOfSubIsland = latestNumberOfSubIsland;
                    }
                    latestListOfIslands.clear();
                    latestNumberOfSubIsland =0;
                }

    }

    public void generatePuzzle(){
        latestListOfIslands = new HashSet<String>();
        previousListOfIslands = new HashSet<String>();
        latestNumberOfSubIsland =0;
        previousNumberOfSubIsland =0;
        earthMatrix = null;
        earthMatrix = Utils.getRandomFiveByFiveMatrix();

    }

    public void solvePuzzle(){
        searchLargestIsland(earthMatrix);
        for(Set<String> largestIslands:listOfLargestIslands){
        for(String key:largestIslands){
            Utils.getEarthHashMap().put(key,android.R.color.holo_green_dark);
        }}
    }

}
