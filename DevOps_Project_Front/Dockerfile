# Utilisation de l'image de base Node.js
FROM node:18.16.1

# Répertoire de travail
WORKDIR /app

# Copier les fichiers du frontend
COPY . .

# Installer les dépendances et construire l'application
RUN npm install
RUN ng build --configuration=production

# Commande pour exécuter l'application (optionnel, car c'est une application front-end)
CMD ["nginx", "-g", "daemon off;"]
