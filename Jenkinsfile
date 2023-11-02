pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build and Test Backend') {
            steps {
                dir('DevOps_Project') {
                    sh 'mvn clean package'
                    sh 'mvn test'
                }
            }
        }
        stage('Build and Test Frontend') {
    steps {
        dir('DevOps_Project_Front') {
            sh '/home/arijhajjaji/.nvm/versions/node/v16.20.2/bin/npm install' // Assurez-vous que le chemin global pour npm est correctement configuré
            sh '/home/arijhajjaji/.nvm/versions/node/v16.20.2/bin/ng build --configuration=production' // Utilisez le chemin complet vers ng
            sh '/home/arijhajjaji/.nvm/versions/node/v16.20.2/bin/ng test' // Utilisez le chemin complet vers ng
        }
    }
}




        stage('Deploy') {
            steps {
                dir('DevOps_Project/target') {
                    sh 'cp your-app.war /path/to/tomcat/webapps'
                }

                dir('DevOps_Project_Front/dist') {
                    sh 'rsync -avz . user@your-server:/path/to/your/website'
                }
            }
        }
    }
}
