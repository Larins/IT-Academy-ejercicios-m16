package com.example.demo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="partidas")
public class Partida {
   
    @Id
    private int id;
    
    @Field(name= "dado1")
    private int dado1;
    
    @Field(name= "dado2")
    private int dado2;
    
    @Field(name="resultado")
    private boolean resultado;
    
    @Field(name="idUser")
    private int idUser;
    
    public Partida(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDado1() {
        return dado1;
    }

    public void setDado1(int dado1) {
        this.dado1 = dado1;
    }

    public int getDado2() {
        return dado2;
    }

    public void setDado2(int dado2) {
        this.dado2 = dado2;
    }

    public boolean isResultado() {
        return resultado;
    }

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("Partida{id=").append(id);
        sb.append(", dado1=").append(dado1);
        sb.append(", dado2=").append(dado2);
        sb.append(", resultado=").append(resultado);
        sb.append('}');
        return sb.toString();
    }
    
    
}
