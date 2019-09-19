package Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tareas.evaluacion.R;

import java.util.List;

import Entidades.Estudiante;

public class AdaptadorEstudiante extends BaseAdapter {
    //Declaracion de variables
    private List<Estudiante> datasource;
    private Context cntx;
    private int IdLayoutPlantilla;


    public List<Estudiante> GetData(){
        return this.datasource;
    }

    public AdaptadorEstudiante(Context context, int IdPlantilla, List<Estudiante> sources){
        this.cntx = context;
        this.IdLayoutPlantilla = IdPlantilla;
        this.datasource = sources;
    }

    @Override
    public int getCount() {
        return this.datasource.size();
    }

    @Override
    public Object getItem(int position) {
        return this.datasource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        //Validamos que no exista un formato

        if(convertView == null){
            //Creamos el Administrador de Layout
            LayoutInflater inflater = (LayoutInflater) this.cntx.getSystemService(this.cntx.LAYOUT_INFLATER_SERVICE);

            //Le damos vida al archivo xml ahora es un Layout
            convertView = inflater.inflate(this.IdLayoutPlantilla,null);

            //Buscamos los controles de nuestra plantilla
            TextView txvCorrelativo = convertView.findViewById(R.id.txvCorrelativo);
            TextView txvNombre = convertView.findViewById(R.id.txvNombre);
            TextView txvCodigo = convertView.findViewById(R.id.txvCodigo);
            TextView txvMateria = convertView.findViewById(R.id.txvMateria);
            TextView txvPromedio = convertView.findViewById(R.id.txvPromedio);

            String i = Integer.toString(this.datasource.get(position).GetId());
            txvCorrelativo.setText(i);

            txvNombre.setText(this.datasource.get(position).GetNombre());
            txvCodigo.setText(this.datasource.get(position).GetCodigo());
            txvMateria.setText(this.datasource.get(position).GetMateria());

            String pro = Double.toString(this.datasource.get(position).GetPromedio());
            txvPromedio.setText(pro);
        }
        return convertView;
    }
}
