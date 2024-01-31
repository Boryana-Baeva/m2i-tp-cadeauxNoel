# Task :
## TP : cadeaux de noel
### Etape 1 : créer un nouveau projet SpringBoot configuré pour créer une API REST et se connecter à postgreSQL
### Etape 2 : créer une Entity Cadeau : nom, description, prix
### Etape 3 : créer un repository pour sauvegarder et lire des cadeaux dans la base
### Etape 4 : tester votre repository avec un JUnit
### Etape 5 : créer un Service avec les méthodes pour: ajouter un cadeau en base et récupérer les cadeaux en base
### Etape 6 : tester dans un nouveau fichier Junit les méthodes du Service
### Etape 7 : créer un Controller pour avoir une API REST avec les routes suivantes:
###         GET /cadeaux
###         POST /cadeaux
###         GET /cadeaux/{id}
###         DELETE /cadeaux/{id}
### Etape 8 : tester manuellement votre API avec une client HTTP
### Etape 9 : Créer un Entity ListeCadeau (nom, ..) et le repository correspondant (modifié)
###             Dans entity Cadeau rajouter un attribut : listeCadeau avec un ManyToOne
###             Dans l’API, quand in affiche un cadeau il faudra afficher à quelle liste il appartient
### Etape 10 : On ne veux pas voir l’id dans le JSON trouvez une solution pour le cacher et ajouter le symbole € lors de l’affichage du prix.
###
## Resultat
###
### GET ALL
### ![img_5.png](img_5.png)

### POST
### ![img_2.png](img_2.png)

### GET ONE
### ![img_3.png](img_3.png)

### DELETE
### ![img_4.png](img_4.png)