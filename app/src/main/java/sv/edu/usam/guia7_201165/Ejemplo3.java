package sv.edu.usam.guia7_201165;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ejemplo3 extends AppCompatActivity {

    EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ejemplo3);

        et1 = findViewById(R.id.etmEj3);

        String[] archivos = fileList();
        if (existe(archivos, "notas.txt")) {
            try {
                InputStreamReader archivo = new InputStreamReader(openFileInput("notas.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while (linea != null) {
                    todo = todo + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                et1.setText(todo);
            } catch (IOException e) {

            }
        }

    }

    private boolean existe(String[] archivos, String archBusca) {
        for (int f = 0; f < archivos.length; f++) {
            if ( archBusca.equals(archivos[f])) {
                return true;
            }
        }
        return false;
    }

    public void grabarEj2(View v) {
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("notas.txt", Activity.MODE_PRIVATE));
            archivo.write(et1.getText().toString());
            archivo.flush();
            archivo.close();
        } catch (IOException e) {}
        Toast t = Toast.makeText(this, "Los datos fueron grabados", Toast.LENGTH_SHORT);
        t.show();
        finish();
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
        }
        if (id == R.id.itemEjercicio1) {
            startActivity(intent4);
            finish();
        }
        if (id == R.id.itemEjercicio2) {
            startActivity(intent5);
            finish();
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