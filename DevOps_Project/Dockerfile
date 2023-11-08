# Utilisation d'une image de base Java
FROM openjdk:11

# Répertoire de travail
WORKDIR /app
# Copier le fichier JAR de l'application
COPY DevOps_Project/target/DevOps_Project-1.0.jar .

# Commande pour exécuter l'application
CMD ["java", "-jar", "DevOps_Project.jar"]
