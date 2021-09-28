package sv.edu.usam.guia7_201165;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class Ex3ListaFrutas extends AppCompatActivity {

    private ArrayList<Frutas> listaFrutas;
    ListView lv;
    Integer[] ImgFutas = {
            R.drawable.aguacate, R.drawable.almendra,
            R.drawable.carambola, R.drawable.cereza,
            R.drawable.ciruela, R.drawable.coco,
            R.drawable.frambuesa, R.drawable.fresa,
            R.drawable.frutadelapasion, R.drawable.kiwi,
            R.drawable.limon, R.drawable.mandarina,
            R.drawable.mango, R.drawable.manzana,
            R.drawable.melocoton, R.drawable.melon,
            R.drawable.naranja, R.drawable.nispero,
            R.drawable.papaya, R.drawable.pera,
            R.drawable.pinia, R.drawable.platano,
            R.drawable.sandia, R.drawable.uva, R.drawable.zarzamora,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3_lista_frutas);

        listaFrutas = new ArrayList<>();
        listaFrutas.add(new Frutas("Aguacate", "Fruta seca"));
        listaFrutas.add(new Frutas("Almendra", "Fruta exótica"));
        listaFrutas.add(new Frutas("Carambola", "Fruta exótica"));
        listaFrutas.add(new Frutas("Cereza", "Fruta dulce"));
        listaFrutas.add(new Frutas("Ciruela", "Fruta dulce"));
        listaFrutas.add(new Frutas("Coco", "Fruta exótica"));
        listaFrutas.add(new Frutas("Frambuesa", "Fruta baya"));
        listaFrutas.add(new Frutas("Fresa", "Fruta baya"));
        listaFrutas.add(new Frutas("Fruta de la pasión", "Fruta exótica"));
        listaFrutas.add(new Frutas("Kiwi", "Fruta exótica"));
        listaFrutas.add(new Frutas("Limón", "Fruta cítrica"));
        listaFrutas.add(new Frutas("Mandarina", "Fruta cítrica"));
        listaFrutas.add(new Frutas("Mango", "Fruta exótica"));
        listaFrutas.add(new Frutas("Manzana", "Fruta dulce"));
        listaFrutas.add(new Frutas("Melocotón", "Fruta dulce"));
        listaFrutas.add(new Frutas("Melón", "Fruta cucurbitácea"));
        listaFrutas.add(new Frutas("Naranja", "Fruta cítrica"));
        listaFrutas.add(new Frutas("Nispero", "Fruta dulce"));
        listaFrutas.add(new Frutas("Papaya", "Fruta exótica"));
        listaFrutas.add(new Frutas("Pera", "Fruta dulce"));
        listaFrutas.add(new Frutas("Piña", "Fruta exótica"));
        listaFrutas.add(new Frutas("Platano", "Fruta exótica"));
        listaFrutas.add(new Frutas("Sandia", "Fruta cucurbitácea"));
        listaFrutas.add(new Frutas("Uva", "Fruta dulce"));
        listaFrutas.add(new Frutas("Zarzamora", "Fruta baya"));

        AdaptadorFrutas adaptador = new AdaptadorFrutas(this, listaFrutas, ImgFutas);
        lv = findViewById(R.id.lsvFrutas);
        lv.setAdapter(adaptador);

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
            finish();
        }
        if (id == R.id.itemEjercicio3) {
            startActivity(intent6);
        }
        if (id == R.id.itemEjercicio4) {
            startActivity(intent7);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

}