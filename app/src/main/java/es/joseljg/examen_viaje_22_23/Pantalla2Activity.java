package es.joseljg.examen_viaje_22_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Pantalla2Activity extends AppCompatActivity {

    public static final String EXTRA_TOTAL_PAGAR = "es.joseljg.examen_viaje_22_23.activity_pantalla2.total_pagar";
    private double total;
    private double total_pagar;
    private double precio;
    private int cantidad;

    private double descuento_grupal;

    private double seguro;


    private EditText edt_total_p2 = null;
    private EditText edt_descuento_p2 = null;

    private EditText edt_seguro_p2 = null;
    private EditText edt_total_pagar_p2 = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);
        //---------------------------------------------------
        edt_total_p2 = (EditText) findViewById(R.id.edt_total_p2) ;
        edt_descuento_p2 = (EditText) findViewById(R.id.edt_descuento_p2);
        edt_seguro_p2 = (EditText) findViewById(R.id.edt_seguro_p2);
        edt_total_pagar_p2 = (EditText) findViewById(R.id.edt_total_pagar_p2);
        //---------------------------------------------------
        Intent intent = getIntent();
        if(intent != null)
        {
            total = intent.getDoubleExtra(MainActivity.EXTRA_TOTAL, 0);
            precio = intent.getDoubleExtra(MainActivity.EXTRA_PRECIO, 0);
            cantidad = intent.getIntExtra(MainActivity.EXTRA_CANTIDAD, 0);
        }
        else{
            total = 0;
            precio = 0;
            cantidad = 0;
        }
        if(cantidad> 10)
        {
            descuento_grupal = total * 0.10;
        }
        else{
            descuento_grupal = 0;
        }
        seguro = cantidad * 2;
        edt_seguro_p2.setText(String.valueOf(seguro));

        edt_total_p2.setText(String.valueOf(total));
        edt_descuento_p2.setText(String.valueOf(descuento_grupal));
       // Toast.makeText(this,String.valueOf(total),Toast.LENGTH_LONG).show();
        total_pagar = total - descuento_grupal + seguro;
        edt_total_pagar_p2.setText(String.valueOf(total_pagar));
    }

    public void calcular_seguro(View view) {
        RadioButton rb = (RadioButton) view;
        if(rb.isChecked())
        {
            switch (view.getId())
            {
                case R.id.rb_seguro_si:
                    seguro = cantidad * 2;
                    break;
                case R.id.rb_seguro_no:
                    seguro = 0;
                    break;
            }
        }
        edt_seguro_p2.setText(String.valueOf(seguro));
        total_pagar = total - descuento_grupal + seguro;
        edt_total_pagar_p2.setText(String.valueOf(total_pagar));
    }

    public void ir_a_pantalla3(View view) {
        Intent intent = new Intent(this, Pantalla3Activity.class);
        intent.putExtra(EXTRA_TOTAL_PAGAR, total_pagar);
        startActivity(intent);
    }
}