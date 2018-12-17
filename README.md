Proxinanquev1_Marie_Julien



1. Prérequis. 

Avant de lancer ProxiBanqueSi, vous devez vous assurer que Java est bien installé sur votre appareil. Si ce n'est pas le cas, vous 

pouvez le télécharger à cette adresse : https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html

Pensez bien à vérifier le niveau de votre Système d'exploitation avant de télécharger. Vous pouvez vérifier votre système d'exploitation 

sous Windows dans Panneau de Configuration -> Système et Sécurité -> Système. Votre niveau de Système correspond à l'indication 

32bits ou 64bits, et vous devez télécharger la distribution de Java correpondante.

Vous devez également avoir un outil pour décompresser les fichiers installé sur votre ordinateur. Si vous n'en avez pas, 

vous pouvez en télécharger un gratuitement ici : https://www.7-zip.org/ 

De même téléchargez bien la version correspond à votre niveau de Système. 

2. Exécution.

Premier point : installation de mysql

Telecharger le soft sur le site ci-après : https://dev.mysql.com/downloads/workbench/

Après l'installation il faut faire un import des données servant à créer la base de donnée. Pour ce faire, dans le soft mysql workbench, aller dans l'onglet Server/Data import/ selectionner "Import from Self-Contained File", aller chercher le fichier dans le repertoire, puis remplir le new schema avec "proxibanquev2". Puis faire start import.

L'opperation doit etre faite deux fois, une avec le fichier "Structureonly.sql" puis avec le fichier "Dataonly.sql". L'ordre doit etre respecté.

Deuxieme point : installation de tomcat

Telecharger le soft sur le site ci-après : https://tomcat.apache.org/download-80.cgi

Extraire le fichier .war compris dans le fichier proxibanquev2-Marie-julien.zip

Après l'installation il faut placer le fichier proxibanquev2.war dans le dossier Webapps ou est installé tomcat.

Pour installer le .war, il faut executer dans S:\...\apache-tomcat-8.5.35\bin\startup.bat.

Démarrer le serveur Tomcat

Installer le fichier .war dans le dossier Webapps de Tomcat

Charger le projet en indiquant dans votre navigateur internet l'adresse URL suisvante :

			localhost:8080/proxibanquev2/

3. Utilisation. 

Proxibanquev2 est une application permettant de de consulter, créer ou effacer des fichier clients 
Et d'effectuer des virements interne pour un client possédant plusieurs comptes.
Il est précisé si il s'agit d'un compte coutant ou d'un compte épargne.
L'application se lance avec toutes les données nécessaires au fonctionement des simulations proposées par l'application. 
Les données sur les clients et les informations des comptes sont stockées dans une base de données.
ces données ont été implémentées via le logicile MySQl Workbench
Les scripts SQL sont intégrés dans le fichier .war
Dans l'application, la simulation se compose de 4 clients.
Ce conseiller possède 4 clients aux identités suivantes (prénom, nom dans cet ordre ici): \
 - Matthew Murdock
 - Gimli Gloinson
 - Thorin Oakenshield
 - Remus Lupin

4. Fonctionalités.

Proxibanquev2 vous permet les fonctionalités suivantes :
 - Créer un nouveau client dans le portefeuille.
 - Consulter la fiche client d'un client : permet d'afficher toutes les informations liées au client.
 - Supprimer client : Supprimer un client de la base de données.\
 - Modifier client : Permet de modifier une information de la liste client.
 - Effectuer des virement entre les différents comptes du client
 - Affiche à l'utilisateur une page erreur et un service  

 
5. Ressources complémentaires.
L'application Proxibanquev2 est livrée avec deux diagrammes UML représentant :
	- Les cas d'utilisation.
	- Le Diagramme de Classe.
	
Est fourni ausii le script SQL de la base de données 
Ainsi qu'une maquette balsamiq de notre projet.


Il est également possible de consulter le code de Proxibanquev2 à l'adresse suivante : 

https://github.com/Chocolaterules/proxibanquev2.git





Merci d'avoir lu ce document. Nous vous souhaitons une bonne expérience avec ProxiBanqueSI. 