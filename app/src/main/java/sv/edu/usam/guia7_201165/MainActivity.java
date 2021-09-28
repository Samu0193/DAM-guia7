package sv.edu.usam.guia7_201165;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        }
        if (id == R.id.itemEjemplo1) {
            startActivity(intent1);
        }
        if (id == R.id.itemEjemplo2) {
            startActivity(intent2);
        }
        if (id == R.id.itemEjemplo3) {
            startActivity(intent3);
        }
        if (id == R.id.itemEjercicio1) {
            startActivity(intent4);
        }
        if (id == R.id.itemEjercicio2) {
            startActivity(intent5);
        }
        if (id == R.id.itemEjercicio3) {
            startActivity(intent6);
        }
        if (id == R.id.itemEjercicio4) {
            startActivity(intent7);
        }
        return super.onOptionsItemSelected(item);
    }

}