package sv.edu.usam.guia7_201165;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class Ex4Reproductor extends AppCompatActivity {

    TextView tvArtista, tvNombre, tvStart, tvFinish;
    Handler handler = new Handler();
    SeekBar seekBar;
    ImageView imgvCatula, btnReplay, btnPrevious, btnPlayPause, btnNext, btnStop, btnRepeat;
    MediaPlayer[] cancion = new MediaPlayer[4];
    String[] titulo = {"Animals", "Five More Hours", "Moves Like Jagger", "Party Rock Anthem"};
    String[] artista = {"Martin Garrix", "Deorro", "Maroon 5 ft. Christina Aguilera", "LMFAO"};
    int[] caratula = {
            R.drawable.animals,
            R.drawable.fivemorehours,
            R.drawable.moveslikejagger,
            R.drawable.partyrockanthem
    };
    int pos = 0;
    int repetir = 2;
    double startTime = 0;
    double finalTime = 0;
    static int tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex4_reproductor);

        // Caratula
        imgvCatula = findViewById(R.id.imgvCaratula);

        // Textos
        tvArtista = findViewById(R.id.tvArtista);
        tvNombre = findViewById(R.id.tvCancion);
        tvStart = findViewById(R.id.tvStartTime);
        tvFinish = findViewById(R.id.tvFinishTime);

        // Barra de progreso
        seekBar = findViewById(R.id.seekBar);

        // Botones
        btnReplay = findViewById(R.id.imgvReplay);
        btnPrevious = findViewById(R.id.imgvPrevious);
        btnPlayPause = findViewById(R.id.imgvPlayPause);
        btnNext = findViewById(R.id.imgvNext);
        btnStop = findViewById(R.id.imgvStop);
        btnRepeat = findViewById(R.id.imgvRepeat);

        cargarCanciones();

        // Metodo reiniar cancion
        btnReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cancion[pos].isPlaying()) {
                    cancion[pos].release();
                    btnPlayPause.setImageResource(R.drawable.btnpause);
                    cargarCanciones();
                    cancion[pos].start();
                }
            }
        });

        // Metodo cancion anterior
        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos >= 1) {
                    if (cancion[pos].isPlaying() || cancion[pos] != null) {
                        cancion[pos].stop();
                        btnPlayPause.setImageResource(R.drawable.btnpause);
                        cargarCanciones();
                        pos--;
                        cancion[pos].start();
                        cargarDatos();
                        imprimirDuracion();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "No hay más canciones", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Metodo play pausa
        btnPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cancion[pos].isPlaying()) {
                    btnPlayPause.setImageResource(R.drawable.btnplay);
                    cancion[pos].pause();
                } else {
                    cancion[pos].start();
                    cargarDatos();
                    btnPlayPause.setImageResource(R.drawable.btnpause);
                    imprimirDuracion();
                }
            }
        });

        // Metodo cancion siguiente
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pos < cancion.length - 1) {
                    if (cancion[pos].isPlaying() || cancion[pos] != null) {
                        btnPlayPause.setImageResource(R.drawable.btnpause);
                        cancion[pos].stop();
                        pos++;
                        cancion[pos].start();
                        cargarDatos();
                        imprimirDuracion();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "No hay más canciones", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Metodo stop
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cancion[pos] != null) {
                    cancion[pos].stop();
                    cargarCanciones();
                    btnPlayPause.setImageResource(R.drawable.btnplay);
                }
            }
        });

        // Metodo repetir cancion
        btnRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (repetir == 1) {
                    btnRepeat.setBackgroundResource(R.drawable.style_circle_grey);
                    Toast.makeText(getApplicationContext(), "No repetir canción", Toast.LENGTH_SHORT).show();
                    cancion[pos].setLooping(false);
                    repetir = 2;
                } else {
                    btnRepeat.setBackgroundResource(R.drawable.style_circle_green);
                    Toast.makeText(getApplicationContext(), "Repetir canción", Toast.LENGTH_SHORT).show();
                    cancion[pos].setLooping(true);
                    imprimirDuracion();
                    repetir = 1;
                }
            }
        });

    }

    private void cargarCanciones() {
        cancion[0] = MediaPlayer.create(getApplicationContext(), R.raw.animals);
        cancion[1] = MediaPlayer.create(getApplicationContext(), R.raw.fivemorehours);
        cancion[2] = MediaPlayer.create(getApplicationContext(), R.raw.moveslikejagger);
        cancion[3] = MediaPlayer.create(getApplicationContext(), R.raw.partyrock);
    }

    private void cargarDatos() {
        imgvCatula.setImageResource(caratula[pos]);
        tvNombre.setText(titulo[pos]);
        tvArtista.setText(artista[pos]);
    }

    private void imprimirDuracion() {
        startTime = cancion[pos].getCurrentPosition();
        finalTime = cancion[pos].getDuration();
        if (tiempo == 0) {
            seekBar.setMax((int)finalTime);
            tiempo = 1;
        }
        tvFinish.setText(String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes((long)finalTime),
                TimeUnit.MILLISECONDS.toSeconds((long)finalTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)finalTime)))
        );
        tvStart.setText(String.format("%d:%d",
                TimeUnit.MILLISECONDS.toMinutes((long)startTime),
                TimeUnit.MILLISECONDS.toSeconds((long)startTime) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)startTime)))
        );
        seekBar.setProgress((int)startTime);
        handler.postDelayed(updateTime, 100);
    }

    private Runnable updateTime = new Runnable() {
        @Override
        public void run() {
            startTime = cancion[pos].getCurrentPosition();
            tvStart.setText(String.format("%d:%d",
                    TimeUnit.MILLISECONDS.toMinutes((long)startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long)startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)startTime)))
            );
            seekBar.setProgress((int)startTime);
            handler.postDelayed(this, 100);
        }
    };

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
            finish();
        }
        if (id == R.id.itemEjercicio4) {
            startActivity(intent7);
        }
        return super.onOptionsItemSelected(item);
    }

}