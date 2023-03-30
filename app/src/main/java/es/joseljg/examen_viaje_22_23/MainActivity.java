package es.joseljg.examen_viaje_22_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    public static final String EXTRA_TOTAL = "es.joseljg.examen_viaje_22_23.mainactivity.total";
    public static final String EXTRA_CANTIDAD ="es.joseljg.examen_viaje_22_23.mainactivity.cantidad" ;
    public static final String EXTRA_PRECIO = "es.joseljg.examen_viaje_22_23.mainactivity.precio" ; ;
    private Spinner sp_ciudad = null;
    private EditText edt_precio = null;
    private EditText edt_cantidad_billetes = null;
    private String ciudadElegida = null;
    private double precioCiudad;

    private int cantidad_billetes;
    private double total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //----------------------------------------------------------
        sp_ciudad = (Spinner) findViewById(R.id.sp_ciudad);
        edt_precio = (EditText) findViewById(R.id.edt_precio);
        edt_cantidad_billetes = (EditText) findViewById(R.id.edt_cantidad_billetes);
        //---------------------------------------------------------------------------
        ciudadElegida = "Toledo";
        precioCiudad = 8.0;
        cantidad_billetes = 0;
        //------------------------------------------------------------------------
        String[] ciudades ={"Madrid","Barcelona","Toledo"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, ciudades);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_ciudad.setAdapter(adapter);
        sp_ciudad.setSelection(2);
        sp_ciudad.setOnItemSelectedListener(this);
        //-------------------------------------------------------------------------

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                 ciudadElegida = adapterView.getItemAtPosition(i).toString();
                 switch (ciudadElegida)
                 {
                     case "Madrid":
                         precioCiudad = 10.0;
                         break;
                     case "Barcelona":
                         precioCiudad=50.0;
                         break;
                     case "Toledo":
                         precioCiudad=8.0;
                         break;
                 }
        edt_precio.setText(String.valueOf(precioCiudad));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        ciudadElegida = "Toledo";
        precioCiudad = 8.0;
        edt_precio.setText(String.valueOf(precioCiudad));
    }

    public void ir_a_pantalla2(View view) {
        String texto_cantidad = String.valueOf(edt_cantidad_billetes.getText());
        if(texto_cantidad.isEmpty())
        {
            edt_cantidad_billetes.setError("debes proporcionar una cantidad de billetes");
            return;
        }
        cantidad_billetes = Integer.valueOf(texto_cantidad);
        total = precioCiudad * cantidad_billetes;
        Intent intent = new Intent(this, Pantalla2Activity.class);
        intent.putExtra(EXTRA_TOTAL,total);
        intent.putExtra(EXTRA_CANTIDAD, cantidad_billetes);
        intent.putExtra(EXTRA_PRECIO, precioCiudad);
        startActivity(intent);
    }
}