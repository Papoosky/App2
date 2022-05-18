package com.uai.app.logic.builders;

import com.uai.app.dominio.Libro;

public class LibroBuilder {

    private String titulo;
    private String autor;
    private int estante_numero;
    private String estante_seccion;
    private int piso;
    private String edificio;
    private String sede;

    public LibroBuilder() {
    }

    public LibroBuilder withTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }
    public LibroBuilder withAutor(String autor) {
        this.autor = autor;
        return this;
    }

    public LibroBuilder withEstante_numero(int estante_numero) {
        this.estante_numero = estante_numero;
        return this;
    }
    public LibroBuilder withEstante_seccion(String estante_seccion) {
        this.estante_seccion = estante_seccion;
        return this;
    }
    public LibroBuilder withPiso(int piso) {
        this.piso = piso;
        return this;
    }
    public LibroBuilder withEdificio(String edificio) {
        this.edificio = edificio;
        return this;
    }

    public LibroBuilder withSede(String sede) {
        this.sede = sede;
        return this;
    }
    //Return the finally consrcuted User object
    public Libro build() {
        Libro book =  new Libro();
        book.setAutor(this.autor);
        book.setEstante_numero(this.estante_numero);
        book.setEstante_seccion(this.estante_seccion);
        book.setTitulo(this.titulo);
        book.setPiso(this.piso);
        book.setEdificio(this.edificio);
        book.setSede(this.sede);
        validateBookObject(book);
        return book;
    }

    private void validateBookObject(Libro user) {
        //Do some basic validations to check
        //if user object does not break any assumption of system
    }
}
