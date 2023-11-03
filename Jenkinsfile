pipeline {
    agent any
	environment {
        DISPLAY = ':99'
    }
	 tools {
        nodejs 'Node.js 20.9.0' 
    }
	stages {
        stage('Setup Xvfb') {
            steps {
                sh 'Xvfb :99 -screen 0 1024x768x16 &'
                sh 'export DISPLAY=:99'
            }
        }

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
