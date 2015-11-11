#SpringDataMongoExample


##InsertDocuments : 
insertion d'une liste de personnes on utilisant une classe qui a comme rôle la génération de données à partir d'un ensemble des paramètres (DataCreator)
L'insertion au niveau de cet exemple se fait via l’implémentation de l interface CrudRepository de spring-data

##RepositorySearchDocument:
recherche d'un document dans la base mongoDB via l'interface CrudRepository en définissant notre query à travers  l'annotation @Query

##CriteriaSearchDocument :
recherche d'un document dans la base mongoDB via MongoOperations, Criteria et Query
Criteria pour créer les condition qui composent la Query
MongoOperations pour lancer l'operation de recherche find

##UpdateDocument:
Mise a jour d'un document 
dans la base mongoDB via MongoOperations, Criteria, Query et Update
on commence par la création de query pour trouver le ou les éléments a modifier puis on crée l'instruction update (champs a modifier avec les valeurs à appliquer)
enfin on lance l’opération updateFirst de MongoOperations pour modifier le premier élément seulement.

##MapReduce: 
exemple d’utilisation de mapReduce qui a comme objectif le calcul de la moyenne d'ages des personnes qui ont comme name 'Monica' et qui habitent à Londre.