Via Postman
URL : http://localhost:8080/api/panier/calcul
Méthode : POST
Body → raw → JSON :
{
  "clientId": "PRO1",
  "produits": {
    "HAUT_DE_GAMME": 3,
    "LAPTOP": 2
  }
}

Clique sur Send

✅ Tu obtiens une réponse :
{
  "total": 4800.0
}
