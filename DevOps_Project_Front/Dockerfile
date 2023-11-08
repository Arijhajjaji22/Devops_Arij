# Utilisation de l'image de base Node.js
FROM node:18.16.1

# Répertoire de travail
WORKDIR /app
# Installer Angular CLI
RUN npm install -g @angular/cli

# Installer les dépendances
RUN npm install

# Construire l'application
RUN ng build --configuration=production

# Commande pour exécuter l'application (optionnel, car c'est une application front-end)
CMD ["nginx", "-g", "daemon off;"]
