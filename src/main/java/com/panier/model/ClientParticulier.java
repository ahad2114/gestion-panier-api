package com.panier.model;

public class ClientParticulier extends Client {
    private String nom;
    private String prenom;

    public ClientParticulier(String id, String nom, String prenom) {
        super(id);
        this.nom = nom;
        this.prenom = prenom;
    }
}
