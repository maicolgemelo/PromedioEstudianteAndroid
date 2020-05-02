package com.example.promedioestudianteandroid;

public class DtoEstudiante {

    private String idUnico;
    private String codigo;
    private String nombre;
    private String nota1;
    private String nota2;
    private String nota3;
    private double promedio;



    public DtoEstudiante(String idUnico, String codigo, String nombre, String nota1, String nota2, String nota3,double promedio) {
        this.idUnico = idUnico;
        this.codigo = codigo;
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.promedio = promedio;

    }

    public String getIdUnico() {
        return idUnico;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNota1() {
        return nota1;
    }

    public String getNota2() {
        return nota2;
    }

    public String getNota3() {
        return nota3;
    }

    public double getPromedio() {
        return promedio;
    }
}