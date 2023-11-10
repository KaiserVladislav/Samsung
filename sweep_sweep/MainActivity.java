package com.example.samsung;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generate();
    }

    // TODO: DECLARATION OF CONSTANTS
    final int WIDTH = 9;
    final int HEIGHT = 9;

    public void generate() {

        // TODO: SECONDARY DECLARATION
        GridLayout layout = findViewById(R.id.GRID);
        layout.removeAllViews();
        layout.setColumnCount(WIDTH);
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);

        Drawable button_pressed_red = getApplicationContext().getResources().getDrawable(R.drawable.button_red_gradient);
        Drawable button_golden = getApplicationContext().getResources().getDrawable(R.drawable.button_golden_gradient);
        Drawable button_unpressed_gray = getApplicationContext().getResources().getDrawable(R.drawable.button_gray_gradient);
        Drawable button_pressed_blue = getApplicationContext().getResources().getDrawable(R.drawable.button_blue_gradient);
        Button retry_button = findViewById(R.id.retry_button);


        Button cells[][];
        cells = new Button[HEIGHT][WIDTH];
        int minefield[][] = MineSweeperFunctional.generateMineField(cells);
        final int[] minesAmount = {0};
        for (int i = 0; i < minefield.length; i++) {
            for (int j = 0; j < minefield[i].length; j++) {
                if(minefield[i][j]==1){
                    minesAmount[0]++;
                }
            }
        }

        TextView game_status;
        game_status = findViewById(R.id.TV);
        game_status.setText(R.string.status_ongoing);

        TextView mines_ratio;
        mines_ratio = findViewById(R.id.TV2);
        mines_ratio.setText("Mines left: "+minesAmount[0]);


        for (int i = 0; i < HEIGHT; i++) { // TODO: Creating buttons (cell.xml type) on layout (Gridlayout class)
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j] = (Button) inflater.inflate(R.layout.cell, layout, false);
            }
        }

        // TODO: MAIN BODY
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                int finalI = i;
                int finalJ = j;

                cells[i][j].setOnClickListener(new View.OnClickListener() {// TODO: [clearing the tile -  pressed mine? IMMEDIATE_DETONATION : clearing area around] setting button red;
                    public void onClick(View view) {
                        cells[finalI][finalJ].setBackground(button_pressed_red);
                        if (minefield[finalI][finalJ]==1){
                            MineSweeperFunctional.detonating(MainActivity.this);
                            game_status.setText(R.string.status_defeat);
                            retry_button.setVisibility(View.VISIBLE);
                            retry_button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    reload();
                                }
                            });

                        }else{
                            int temp[] = MineSweeperFunctional.clearing(minefield,finalI,finalJ);
                            cells[temp[0]][temp[1]].setText(temp[2]+"");
                        }
                    }
                });

                cells[i][j].setOnLongClickListener(new View.OnLongClickListener() { // TODO: [marking the tile with mine flag - purely dysfunctional] setting button blue;
                    @Override
                    public boolean onLongClick(View v) {
                        cells[finalI][finalJ].setBackground(button_pressed_blue);
                        if (minefield[finalI][finalJ]==1){
                            minesAmount[0] -=1;
                        }
                        if (minesAmount[0]==0){
                            MineSweeperFunctional.win(MainActivity.this);
                            game_status.setText(R.string.status_victory);
                            retry_button.setVisibility(View.VISIBLE);
                            retry_button.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    reload();
                                }
                            });
                        }
                        mines_ratio.setText("Mines left: "+minesAmount[0]);
                        return true;
                    }
                });

                // TODO: SETTING TEXT
                //cells[i][j].setText(i + " " + j);
                //cells[i][j].setTag(i + " " + j);


                layout.addView(cells[i][j]);
                Log.i("", minefield[i][j] + " " + (i+1) + " " + (j+1));

            }
        }


    }
    public void reload(){ // I dunno man
        setContentView(R.layout.activity_main);
        generate();
    }


}
