package com.tareas.evaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import Adaptadores.AdaptadorEstudiante;
import Entidades.Estudiante;

import static com.tareas.evaluacion.MainActivity.listEstudiantes;

public class ListaEstudiante extends AppCompatActivity {
    ListView listvEstudiantes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_estudiante);

        listvEstudiantes = findViewById(R.id.listvEstudiante);

        listvEstudiantes.setAdapter(new AdaptadorEstudiante(this, R.layout.list_item, listEstudiantes));

    }
}
