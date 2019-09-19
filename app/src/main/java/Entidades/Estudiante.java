package Entidades;

public class Estudiante {
    //Declaramos los atributos
    private int id;
    private String nombre;
    private String codigo;
    private String materia;
    private double parcial1;
    private double parcial2;
    private double parcial3;
    private double promedio;

    public Estudiante(){

    }

    public Estudiante(int i, String n, String c, String m, double p){
        this.id = i;
        this.nombre = n;
        this.codigo = c;
        this.materia = m;
        this.promedio = p;
    }

    //Declaramos los metodos de acceso
    public void SetId(int value){
        this.id = value;
    }
    public int GetId(){
        return this.id;
    }

    public void SetNombre(String value){
        this.nombre = value;
    }
    public String GetNombre(){
        return this.nombre;
    }

    public void SetCodigo(String value){
        this.codigo = value;
    }
    public String GetCodigo(){
        return this.codigo;
    }

    public void SetMateria(String value){
        this.materia = value;
    }
    public String GetMateria(){
        return this.materia;
    }

    public void SetParcial1(double value){
        this.parcial1 = value;
    }
    public double GetParcial1(){
        return this.parcial1;
    }

    public void SetParcial2(double value){
        this.parcial2 = value;
    }
    public double GetParcial2(){
        return this.parcial2;
    }

    public void SetParcial3(double value){
        this.parcial3 = value;
    }
    public double GetParcial3(){
        return this.parcial3;
    }

    public void SetPromedio(double value){
        this.promedio = value;
    }
    public double GetPromedio(){
        return this.promedio;
    }
}

