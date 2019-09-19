package com.tareas.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Entidades.Estudiante;

public class MainActivity extends AppCompatActivity {
    public static List<Estudiante> listEstudiantes;
    public static final int ID = 1;
    public static final String TAG_MENSAJE = "MSJ";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listEstudiantes = new ArrayList<>();
    }

    public void OnClickNuevoEstudiante(View v){
        Intent in = new Intent(this, NuevoEstudiante.class);
        startActivityForResult(in, ID);
    }

    public void OnClickListaEstudiante(View v){
        if(listEstudiantes.isEmpty()){
            Toast.makeText(this, "La lista se escuentra vacía", Toast.LENGTH_SHORT).show();
        }
        else{
            Intent in = new Intent(this, ListaEstudiante.class);
            startActivity(in);
        }
    }

    public void OnClickDatos(View v){
        Intent in = new Intent(this, Datos.class);
        startActivity(in);
    }

    public void onActivityResult(int RequestCode, int ResultCode, Intent datos){
        super.onActivityResult(RequestCode,ResultCode,datos);
        switch(RequestCode){
            case ID: {
                if (ResultCode == RESULT_OK) {
                    String mensaje = datos.getStringExtra(TAG_MENSAJE);
                    Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }
}
