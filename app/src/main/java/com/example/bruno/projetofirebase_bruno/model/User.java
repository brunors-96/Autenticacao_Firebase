package com.example.bruno.projetofirebase_bruno.model;

import com.google.firebase.auth.FirebaseUser;

public class User {
    private String id;
    private String nome;
    private String bDay;
    private String graduacao;

    public User(FirebaseUser user) {
        this.id = user.getUid();
    }

    public User(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getBDay() {
        return bDay;
    }

    public void setBDay(String bDay) {
        this.bDay = bDay;
    }

    public String getGraduacao() {
        return graduacao;
    }

    public void setGraduacao(String graduacao) {
        this.graduacao = graduacao;
    }
}
