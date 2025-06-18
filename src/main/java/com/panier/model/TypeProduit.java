package com.panier.model;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Type de produit disponible à l'achat")
public enum TypeProduit {

    @Schema(description = "Téléphone haut de gamme (ex. iPhone Pro, Samsung Ultra)")
    HAUT_DE_GAMME(1500),

    @Schema(description = "Téléphone milieu de gamme (ex. Samsung A54, Pixel 7a)")
    MOYEN_DE_GAMME(800),

    @Schema(description = "Ordinateur portable (ex. MacBook, Dell XPS)")
    LAPTOP(1200);

    private final double prixParticulier;

    TypeProduit(double prixParticulier) {
        this.prixParticulier = prixParticulier;
    }

    public double getPrixPour(Client client) {
        if (client instanceof ClientParticulier) return prixParticulier;

        ClientProfessionnel pro = (ClientProfessionnel) client;
        double ca = pro.getChiffreAffaires();

        return switch (this) {
            case HAUT_DE_GAMME -> ca > 10_000_000 ? 1000 : 1150;
            case MOYEN_DE_GAMME -> ca > 10_000_000 ? 550 : 600;
            case LAPTOP -> ca > 10_000_000 ? 900 : 1000;
        };
    }
}
