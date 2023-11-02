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
               sh '/home/arijhajjaji/.nvm/versions/node/v20.9.0/bin/npm install'
               sh '/home/arijhajjaji/.nvm/versions/node/v20.9.0/bin/ng build --configuration=production'
               sh '/home/arijhajjaji/.nvm/versions/node/v20.9.0/bin/ng test'
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
