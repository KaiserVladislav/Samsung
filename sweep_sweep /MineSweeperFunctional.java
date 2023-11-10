package com.example.samsung;

import android.content.Context;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MineSweeperFunctional {
    public static int[][]  generateMineField(Button[][] cells){
        int mineField[][]=new int[cells.length][cells[0].length];
        Random random = new Random(); // todo: target mines amount ~ 8 (of 81 cells)
        int limit=9;
        int counter=0;
        for (int i = 0; i < mineField.length; i++) {
            for (int j = 0; j < mineField[i].length; j++) {
                mineField[i][j]= (random.nextInt(100)==8)?1:0; // pls change later
            }
        }

        return mineField;
    }

    public static void detonating(Context context){
        Toast.makeText(context, R.string.status_defeat,Toast.LENGTH_SHORT).show();
    }
    public static void win(Context context){
        Toast.makeText(context, R.string.status_victory,Toast.LENGTH_SHORT).show();
    }


    public static int[] clearing(int[][] minefield, int i, int j){
        int mines_around=0;
        int index_i=i;
        int index_j=j;

            for (int k = 0; k < 3; k++) {
                for (int l = 0; l < 3; l++) {
                    try{
                        if (minefield[index_i-1+k][index_j-1+l] ==1){
                            mines_around++;
                        }
                    }catch (ArrayIndexOutOfBoundsException idontcare){
                        continue;
                    }

                }
            }

        int[] result = new int[3];
        result[0]=index_i;
        result[1]=index_j;
        result[2]=mines_around;
        return result;
    }


}
