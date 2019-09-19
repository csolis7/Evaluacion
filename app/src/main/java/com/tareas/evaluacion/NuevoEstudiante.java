package com.tareas.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

import Entidades.Estudiante;

import static com.tareas.evaluacion.MainActivity.TAG_MENSAJE;
import static com.tareas.evaluacion.MainActivity.listEstudiantes;

public class NuevoEstudiante extends AppCompatActivity {
    EditText edtNombre, edtCodigo, edtMateria, edtPrimer, edtSegundo, edtTercer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_estudiante);
        edtNombre = findViewById(R.id.edtNombre);
        edtCodigo = findViewById(R.id.edtCodigo);
        edtMateria = findViewById(R.id.edtMateria);
        edtPrimer = findViewById(R.id.edtPrimer);
        edtSegundo = findViewById(R.id.edtSegundo);
        edtTercer = findViewById(R.id.edtTercer);
    }
    public void OnClickGuardar(View v){
        if(Verificacion()){
            Estudiante e = new Estudiante();
            double pro = (Double.parseDouble(edtPrimer.getText().toString()) * 0.3) +
                    (Double.parseDouble(edtSegundo.getText().toString()) * 0.3) +
                    (Double.parseDouble(edtTercer.getText().toString()) * 0.4);

            e.SetId(listEstudiantes.size() + 1);
            e.SetNombre(edtNombre.getText().toString());
            e.SetCodigo(edtCodigo.getText().toString());
            e.SetMateria(edtMateria.getText().toString());
            e.SetParcial1(Double.parseDouble(edtPrimer.getText().toString()));
            e.SetParcial2(Double.parseDouble(edtSegundo.getText().toString()));
            e.SetParcial3(Double.parseDouble(edtTercer.getText().toString()));


            DecimalFormatSymbols separadoresPersonalizados = new DecimalFormatSymbols();
            separadoresPersonalizados.setDecimalSeparator('.');
            DecimalFormat f1 = new DecimalFormat("#.##", separadoresPersonalizados);

            e.SetPromedio(Double.parseDouble(f1.format(pro)));
            listEstudiantes.add(e);

            Intent msj = new Intent();
            msj.putExtra(TAG_MENSAJE, "Estudiante ingresado con éxito");
            setResult(RESULT_OK, msj);
            this.finish();
        }
    }

    private boolean Verificacion(){
        boolean veri = true;

        if(edtNombre.getText().toString().isEmpty()){veri = false;}
        if(edtCodigo.getText().toString().isEmpty()){veri = false;}
        if(edtMateria.getText().toString().isEmpty()){veri = false;}
        if(edtPrimer.getText().toString().isEmpty()){veri = false;}
        if(edtSegundo.getText().toString().isEmpty()){veri = false;}
        if(edtTercer.getText().toString().isEmpty()){veri = false;}

        if(!veri){
            Toast.makeText(this, "Digite todos los campos", Toast.LENGTH_SHORT).show();}

        return veri;
    }
}
