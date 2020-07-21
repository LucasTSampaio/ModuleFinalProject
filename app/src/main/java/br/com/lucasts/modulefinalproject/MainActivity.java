package br.com.lucasts.modulefinalproject;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int pointsRyu = 0;
    int pointsKen = 0;
    int pointsLee = 0;


    TextView showChampion;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable background = getDrawable(R.drawable.background_ryu);
        background.setAlpha(80);


        showChampion = findViewById(R.id.show_won_champion);
        showChampion.setVisibility(View.GONE);

        ryuData();
        kenData();
        leeData();
        resultChampion();
    }

    private void ryuData(){
        Button btn_ryu_won = findViewById(R.id.won_ryu);
        Button btn_ryu_lose = findViewById(R.id.lose_ryu);

        btn_ryu_won.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointsRyu ++;
            }
        });

        btn_ryu_lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointsRyu --;
            }
        });
    }

    private void kenData(){
        Button btn_ken_won = findViewById(R.id.won_ken);
        Button btn_ken_lose = findViewById(R.id.lose_ken);

        btn_ken_won.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointsKen ++ ;
            }
        });

        btn_ken_lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointsKen -- ;
            }
        });

    }

    private void leeData(){
        Button btn_lee_won = findViewById(R.id.won_lee);
        Button btn_lee_lose = findViewById(R.id.lose_lee);

        btn_lee_won.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointsLee ++;
            }
        });

        btn_lee_lose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointsLee --;
            }
        });


    }

    private void resultChampion() {

        Button btn_champion = findViewById(R.id.who_won_btn);

        final TextView rank = findViewById(R.id.show_rank);

        btn_champion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if ((pointsRyu > pointsKen) && (pointsRyu > pointsLee)) {
                    showChampion.setText("RYU CAMPEÃO!!!");
                    showChampion.setVisibility(View.VISIBLE);

                } else if ((pointsKen > pointsRyu) && (pointsKen > pointsLee)){
                    showChampion.setText("KEN CAMPEÃO!!!");
                    showChampion.setVisibility(View.VISIBLE);

                } else if((pointsLee > pointsRyu) && (pointsLee > pointsKen)){
                    showChampion.setText("LEE CAMPEÃO!!!");
                    showChampion.setVisibility(View.VISIBLE);
                } else {
                    showChampion.setText("TEMOS UM EMPATE!");
                    showChampion.setVisibility(View.VISIBLE);
                }

                rank.setText("Ryu: "+pointsRyu +"\nKen: "+pointsKen+"\nLee: "+pointsLee );

            }
        });



    }

}
