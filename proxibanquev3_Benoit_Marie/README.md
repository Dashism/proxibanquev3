Ce document a pour objectif de vous aider à utiliser l'application.

Table des Matières : 1 - Prérequis 2 - Execution 3 - Utilisation 4 - Fonctionalités 5 - Ressources complémentaires

ATTENTION : Ce document contient des informations importantes pour le fonctionnement de ProxiBanqueSI. Veuillez le lire attentivement pour vous assurer la meilleure expérience possible. Les développeurs ne sauraient être tenus responsables d'une mauvaise utilisation de l'application découlant d'une mauvaise ou absence de lecture de ce document.



1 - Prérequis. Avant de lancer ProxiBanqueSi, vous devez vous assurer que Java est bien installé sur votre appareil. Si ce n'est pas le cas, vous pouvez le télécharger à cette adresse : https://www.oracle.com/technetwork/java/javase/downloads/jre8-downloads-2133155.html Pensez bien à vérifier le niveau de votre Système d'exploitation avant de télécharger. Vous pouvez vérifier votre système d'exploitation sous Windows dans Panneau de Configuration -> Système et Sécurité -> Système. Votre niveau de Système correspond à l'indication 32bits ou 64bits, et vous devez télécharger la distribution de Java correpondante. Vous devez également avoir un outil pour décompresser les fichiers installé sur votre ordinateur. Si vous n'en avez pas, vous pouvez en télécharger un gratuitement ici : https://www.7-zip.org/ De même téléchargez bien la version correspondant à votre niveau de Système. Afin d'utiliser l'application de manière optimale, nous vous recommendons d'utiliser Google Chrome. Vous pouvez télécharger Google Chrome ici : https://www.google.com/chrome/. Encore une fois n'oubliez pas de vérifier le niveau de votre Système.
Afin de pouvoir profiter de l'application , il est nécessaire de télécharger et d'installer Tomcat. Il est téléchargeable à l'adresse suivante : https://tomcat.apache.org/download-80.cgi. Veuillez choisir l'installation correspondante à votre système d'exploitation dans "Binary Distributions --> Core". Par exemple, pour Windows 7 ou supérieur, veuillez cliquer sur "64-bit Windows.zip". Une fois l'archive téléchargée, veuillez l'extraire sur votre PC, le dossier de destination n'ayant pas d'importance. Il est également nécessaire de définir une nouvelle variable d'environnement "JRE_HOME". Pour cela, dans l'explorateur de fichiers, faites clic droit sur "Ce PC" -> Propriétés. Selectionnez "Paramètres système avancés" sur la gauche. Dans la fenêtre ouverte, choisir "variables d'environnement". Sous le tableau "Variables système", Cliquer sur nouvelle : En "Nom de variable" indiquer JRE_HOME et en chemin de variable, il faut récupérer le chemin vers l'installation du jre ( par défaut C:\Programmes\java\jrexxx ).

Pour avoir accès aux données client, veuillez télécharger l'application MySQL à l'adresse suivante : https://dev.mysql.com/downloads/windows/installer/8.0.html. Selectionnez l'installation à 313Mo. Bien vérifier que MySQL Workbench est installé.




2 - Exécution. Afin de deployer l'application ProxiBanque, veuillez coller l'archive proxibanquev3_Benoit_Marie.war dans le dossier webapps de votre dossier apache-tomcat-8.5.35. Ensuite, allez dans le dossier bin et double cliquez sur le fichier "startup.bat". Attendre qu'un dossier proxibanquev3 apparaisse.
Veuillez ensuite lancer MySQL Workbench et créer un nouveau schéma nommé "proxibanquev3". Ensuite, selectionner "Server" dans le menu supérieur puis "Data import". Selectionner l'option "Import from Self-Contained File et renseigner le chemin vers le fichier structure.sql fourni. Indiquer "proxibanquev3" dans "Default Target Schema". Enfin, répéter l'opération précédente avec le script "data.sql" fourni afin d'importer les données proprement dites.

Pour lancer l'application, lancer chrome et rentrer l'adresse suivante : "http://localhost:8080/proxibanquev3".




3 - Utilisation. ProxiBanqueSI est une application permettant de simuler la gestion des comptes d'un client précedement identifié. Afin de pouvoir lancer l'application vous devez charger une base de données fictives.
Dans l'application, la simulation se compose de plus de cinq clients, comportent les caractéristiques suivantes : un identifiant, un numéro sur 8 chiffres, un nom, prénom, une date de  naissance, une adresse et des comptes. Il est possible d'explorer l'ensemble des fonctionnalités avec les données fournies dans l'application.
Les comptes clients sont de type compte courant et/ou compte épargne, et possèdent les  propriétés suivantes : un identifiant, un solde, un numéro de compte sur 13 chiffres, un libellé,  une date d’ouverture. Chaque compte courant a toujours une unique carte bleue associée de type  Visa electron ou Visa premier. Chaque compte peu importe son type peut avoir un unique chéquier.  
L’adresse du client est composé de : pays, ville, code  postal, et deux lignes d’adresse principale et secondaire (bâtiment, étage, etc... ).  
Chaque carte bleue possède un identifiant, une date d’expiration et son numéro sur 16 chiffres en  plus de son type.  
Le chéquier est caractérisé par un identifiant, une date d’envoi et une date de réception.

Pour tester l'application voici des exemples de noms de client present dans la base de donné :
- Harry Potter
- Tony Stark
- Diana Price
- Martha Hudson

Une fois que votre usage de l'application touche à son terme, lancez le fichier "shutdown.bat" dans le même dossier que "startup.bat"(Apache Tomcat/bin).




4 - Fonctionalités. ProxiBanqueSI vous permet ces fonctionalités : -l'identification du client par le nom et le prenom (dans n'importe quel ordre); -Le dashboard permet un listing complet de tout les comptes du client identifié (courant et épargne); -Faire un virement entre deux comptes d'un client identifié; -Retirer de l'argent en liquide en fonction du compte selectionné; -Faire un retrait de carte banquaire; -Faire un retrait de chequier;
ATTENTION : ProxiBanqueSI traite la l'erreur d'identification si un nom et prenom incorrect sont rentré dans la bar de recherche.




5 - Ressources complémentaires. L'application ProxiBanqueSI est livrée avec :
- Le Diagramme de Classe;
- Les scripts sql pour générer la base de données.

Il est également possible de consulter le code de ProxiBanqueSI V3 à l'adresse suivante : "https://github.com/Dashism/proxibanquev3".