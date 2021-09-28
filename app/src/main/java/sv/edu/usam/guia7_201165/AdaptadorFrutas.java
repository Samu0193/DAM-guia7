package sv.edu.usam.guia7_201165;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorFrutas extends ArrayAdapter<Frutas> {

    Activity contexto;
    ArrayList<Frutas> frutas;
    Integer[] ImgFrutas;
    ImageView imgFoto;
    TextView tvNombre;

    public AdaptadorFrutas(Activity contexto, ArrayList<Frutas> frutas, Integer[] imgFrutas) {
        super(contexto, R.layout.frutas, frutas);
        this.contexto = contexto;
        this.frutas = frutas;
        this.ImgFrutas = imgFrutas;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = contexto.getLayoutInflater();
        View item = inflater.inflate(R.layout.frutas, null);
        tvNombre = item.findViewById(R.id.tvNombreFruta);
        tvNombre.setText(frutas.get(position).getNombre() + "\n" +frutas.get(position).getDescripcion());
        imgFoto = item.findViewById(R.id.imgvFruta);
        imgFoto.setImageResource(ImgFrutas[position]);
        return(item);
    }

}
