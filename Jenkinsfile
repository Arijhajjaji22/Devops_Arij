pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                // Récupérer le code source depuis le référentiel
                checkout scm
            }
        }

        stage('Build and Test Backend') {
            steps {
                dir('backend') {
                    // Build Spring Boot backend
                    sh 'mvn clean package'
                    // Exécutez les tests
                    sh 'mvn test'
                }
            }
        }

        stage('Build and Test Frontend') {
            steps {
                dir('frontend') {
                    // Installation des dépendances Angular
                    sh 'npm install'
                    // Build de l'application Angular
                    sh 'ng build --prod'
                    // Exécutez les tests Angular
                    sh 'ng test'
                }
            }
        }

        stage('Deploy') {
            steps {
                // Ajoutez les étapes de déploiement ici
                // Par exemple, vous pouvez déployer le backend et le frontend sur un serveur ou dans des conteneurs Docker.
            }
        }
    }
}
