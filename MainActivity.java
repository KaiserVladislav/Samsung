package com.example.shendrik_cells;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TextView;
import android.widget.Toast;

/*TODO: minefield I
*  1) placing mines
*  2) */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mines_status = findViewById(R.id.TV);
        mines_status.setText(""+MINESCONST+"/"+MinesCurrent);
        generate();
    }

    // declaration
    TextView mines_status;
    final int MINESCONST=3;
    int MinesCurrent=3;
    Button cells[][];
    boolean cells_mines[][];
    final int WIDTH=10;
    final int HEIGHT=10;

    public void generate(){
        GridLayout layout = findViewById(R.id.GRID);
        layout.removeAllViews();
        layout.setColumnCount(WIDTH);
        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);

        cells = new Button[HEIGHT][WIDTH];
        cells_mines=new boolean[HEIGHT][WIDTH];
        for(int i=0;i<HEIGHT;i++){
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j]= (Button) inflater.inflate(R.layout.cell,layout,false);
            }
        }
        for(int i=0;i<HEIGHT;i++){
            for (int j = 0; j < WIDTH; j++) {
                cells[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        view.setBackgroundColor(getColor(R.color.red));
                    }
                });
                cells[i][j].setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        v.setBackgroundColor(Color.BLUE);


//                        if(MinesCurrent==0){
//                            Toast.makeText(getApplicationContext(),"WIN",Toast.LENGTH_LONG).show();
//                        }
                        return true;
                    }
                });

                cells[i][j].setText((i+1)+" "+(j+1));
                cells[i][j].setTag(""+j+HEIGHT*(i+1));
                layout.addView(cells[i][j]);

            }
        }

    }
}