package com.waterislandpuzzle;

/**
 * Created by gaurav.saki on 11/10/2016.
 */
public class Constants {
    static final int ROW = 5, COL = 5;
    // These arrays are used to get row and column numbers
    // of 8 neighbors of a given cell
  /*          int ROW_N[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
            int COL_N[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};*/

    // These arrays are used to get row and column numbers
    // of 8 neighbors of a given cell
    static final int ROW_N[] = new int[] { -1,  0,  0, 1};
    static final int COL_N[] = new int[] {  0,  1, -1, 0};
    static final int NEIGH_N = 4;
}
