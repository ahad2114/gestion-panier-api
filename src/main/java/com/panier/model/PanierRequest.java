package com.panier.model;

import java.util.Map;

public class PanierRequest {
    private String clientId;
    private Map<TypeProduit, Integer> produits;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public Map<TypeProduit, Integer> getProduits() {
        return produits;
    }

    public void setProduits(Map<TypeProduit, Integer> produits) {
        this.produits = produits;
    }
}