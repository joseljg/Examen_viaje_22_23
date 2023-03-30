package es.joseljg.examen_viaje_22_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class Pantalla3Activity extends AppCompatActivity {

    private double total_pagar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);

        Intent intent = getIntent();
        if(intent!=null)
        {
            total_pagar = intent.getDoubleExtra(Pantalla2Activity.EXTRA_TOTAL_PAGAR,0.0);
        }
        else{
            total_pagar = 0;
        }
      //  Toast.makeText(this,"el total a pagar es " + String.valueOf(total_pagar), Toast.LENGTH_LONG).show();
    }
}