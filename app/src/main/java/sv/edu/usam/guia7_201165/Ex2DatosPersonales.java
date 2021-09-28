package sv.edu.usam.guia7_201165;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Ex2DatosPersonales extends AppCompatActivity {

    private EditText et1, et2, et3;
    private TextView et4;
    private Button btn1, btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2_datos_personales);

        et1 = findViewById(R.id.etNomEx2);
        et2 = findViewById(R.id.etMailEx2);
        et3 = findViewById(R.id.etDirEx2);
        et4 = findViewById(R.id.tvDatosEx2);
        btn1 = findViewById(R.id.btnGrabarEx2);
        btn2 = findViewById(R.id.btnRecuperarEx2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = et1.getText().toString();
                String mail = et2.getText().toString();
                String direccion = et3.getText().toString();
                SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString(nombre, mail + "\n" + direccion);
                editor.commit();
                Toast.makeText(getApplicationContext(),"Datos grabados", Toast.LENGTH_LONG).show();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = et1.getText().toString();
                SharedPreferences prefe = getSharedPreferences("datos", Context.MODE_PRIVATE);
                String d = prefe.getString(nombre, "");
                if (d.length() == 0) {
                    Toast.makeText(getApplicationContext(),"No existe dicho nombre en la agenda", Toast.LENGTH_LONG).show();
                }
                else {
                    et4.setText(d);
                }
            }
        });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.opciones, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        Intent intent = new Intent(this, MainActivity.class);
        Intent intent1 = new Intent(this, Ejemplo1.class);
        Intent intent2 = new Intent(this, Ejemplo2.class);
        Intent intent3 = new Intent(this, Ejemplo3.class);
        Intent intent4 = new Intent(this, Ex1Trabajadores.class);
        Intent intent5 = new Intent(this, Ex2DatosPersonales.class);
        Intent intent6 = new Intent(this, Ex3ListaFrutas.class);
        Intent intent7 = new Intent(this, Ex4Reproductor.class);

        if (id == R.id.itemPrincipal) {
            startActivity(intent);
            finish();
        }
        if (id == R.id.itemEjemplo1) {
            startActivity(intent1);
            finish();
        }
        if (id == R.id.itemEjemplo2) {
            startActivity(intent2);
            finish();
        }
        if (id == R.id.itemEjemplo3) {
            startActivity(intent3);
            finish();
        }
        if (id == R.id.itemEjercicio1) {
            startActivity(intent4);
            finish();
        }
        if (id == R.id.itemEjercicio2) {
            startActivity(intent5);
        }
        if (id == R.id.itemEjercicio3) {
            startActivity(intent6);
            finish();
        }
        if (id == R.id.itemEjercicio4) {
            startActivity(intent7);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}