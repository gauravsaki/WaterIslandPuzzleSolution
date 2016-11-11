package com.waterislandpuzzle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 * Created by gaurav.saki on 11/10/2016.
 */
public class Utils {
    private static LinkedHashMap<String,Integer> earthHashMap;
    // //We could have used  LinkedHashMap<Integer,LinkedHashMap<Integer,Island>> for 5*5 array
    private static LinkedHashMap<Integer,LinkedHashMap<Integer,Island>> earthLinkedHashMap;
    public static LinkedHashMap<String, Integer> getEarthHashMap() {
        return earthHashMap;
    }

    public static void setEarthHashMap(LinkedHashMap<String, Integer> earthHashMap) {
        Utils.earthHashMap = earthHashMap;
    }

    public static int[][] getRandomFiveByFiveMatrix(){
        int[][] earth = new int[Constants.ROW][Constants.COL];
       // earthLinkedHashMap  = new LinkedHashMap<>();
        earthHashMap = new LinkedHashMap<String,Integer>();
        int counter =0;
        for (int i = 0; i < earth.length; i++)
        {
           // LinkedHashMap<Integer,Island>  waterIslandLinkedHashMap = new LinkedHashMap<>();
            for (int j = 0; j < earth.length; j++)
            {
               // Island island = new Island();
                int isIslandOrWater = getIslandOrWater();
                earth[ i ][ j ]=isIslandOrWater;
               // island.setColor(isIslandOrWater);
               // island.setIndex(counter);
                //island.setPosition(i+"-"+j);
               // waterIslandLinkedHashMap.put(j,island);
                counter++;
                earthHashMap.put(i+"-"+j,isIslandOrWater==1?R.color.beautiful_peach:R.color.very_light_blue);


            }
           // earthLinkedHashMap.put(i,waterIslandLinkedHashMap);
           // System.out.print(earthLinkedHashMap);
        }
        return earth;
    }

    private static int getIslandOrWater(){
        Random rand = new Random();
        return rand.nextInt(2);
    }

}
