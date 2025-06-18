package com.panier.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Map;

@Schema(description = "Requête pour calculer le total d’un panier client")
public class PanierRequest {

    @Schema(description = "Identifiant du client (ex: 'C1' ou 'PRO1')", example = "PRO1", required = true)
    private String clientId;

    @Schema(
            description = "Liste des produits avec leur quantité. La clé est le type de produit (HAUT_DE_GAMME, MOYEN_DE_GAMME, LAPTOP), la valeur est la quantité.",
            example = "{\"HAUT_DE_GAMME\": 2, \"LAPTOP\": 1}",
            required = true
    )
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