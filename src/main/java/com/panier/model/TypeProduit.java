package com.panier.model;

public enum TypeProduit {
    HAUT_DE_GAMME(1500),
    MILIEU_DE_GAMME(800),
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
            case MILIEU_DE_GAMME -> ca > 10_000_000 ? 550 : 600;
            case LAPTOP -> ca > 10_000_000 ? 900 : 1000;
        };
    }
}
