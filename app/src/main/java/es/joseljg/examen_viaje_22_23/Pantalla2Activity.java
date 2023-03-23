package es.joseljg.examen_viaje_22_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Pantalla2Activity extends AppCompatActivity {

    private double total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        //---------------------------------------------------
        Intent intent = getIntent();
        if(intent != null)
        {
            total = intent.getDoubleExtra(MainActivity.EXTRA_TOTAL, 0);
        }
        else{
            total = 0;
        }

        Toast.makeText(this,String.valueOf(total),Toast.LENGTH_LONG).show();
    }
}