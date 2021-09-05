package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="jugadores")
public class Jugador {
    @Id
    private int id;
    @Field (name="nombre")
    private String nombre;
    @Field (name="email")
    private String email;
    @Field (name="password")
    private String password;
    @Field (name="nick")
    private String nick;
   
    public Jugador(String nombre, String password){
        this.nombre=nombre;
        this.password=password;
    }
    public Jugador(){
      
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
