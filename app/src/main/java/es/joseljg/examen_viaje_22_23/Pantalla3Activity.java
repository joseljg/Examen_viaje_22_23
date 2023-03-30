package es.joseljg.examen_viaje_22_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pantalla3Activity extends AppCompatActivity {

    private double total_pagar;

    private double saldo_disponible;
    private EditText edt_total_pagar_p3;
    private EditText edt_saldo_disponible_p3;

    private Button bt_pagar_p3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla3);
        saldo_disponible = 500;
//-----------------------------------------------------------------------
        edt_total_pagar_p3 = (EditText) findViewById(R.id.edt_total_pagar_p3);
        edt_saldo_disponible_p3 = (EditText) findViewById(R.id.edt_saldo_p3);
        bt_pagar_p3 = (Button) findViewById(R.id.bt_pagar_p3);

        Intent intent = getIntent();
        if(intent!=null)
        {
            total_pagar = intent.getDoubleExtra(Pantalla2Activity.EXTRA_TOTAL_PAGAR,0.0);
        }
        else{
            total_pagar = 0;
        }
      //  Toast.makeText(this,"el total a pagar es " + String.valueOf(total_pagar), Toast.LENGTH_LONG).show();
        edt_total_pagar_p3.setText(String.valueOf(total_pagar));
        edt_saldo_disponible_p3.setText(String.valueOf(saldo_disponible));
    }

    public void pagar_p3(View view) {
        if(total_pagar > saldo_disponible)
        {
            Toast.makeText(this,"NO TIENES SUFICIENTE SALDO PARA PAGAR", Toast.LENGTH_LONG).show();
        }
        else{
            saldo_disponible = saldo_disponible - total_pagar;
            Toast.makeText(this,"PAGO REALIZADO CORRECTAMENTE", Toast.LENGTH_LONG).show();
            total_pagar = 0;
            edt_total_pagar_p3.setText(String.valueOf(total_pagar));
            edt_saldo_disponible_p3.setText(String.valueOf(saldo_disponible));
            bt_pagar_p3.setEnabled(false);

        }
    }
}