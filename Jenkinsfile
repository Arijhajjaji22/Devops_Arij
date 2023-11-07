pipeline {
    agent any
	environment {
        DISPLAY = ':99'
		 SONARQUBE_URL = 'http://localhost:9000'
		 
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
      
        }
    }
}
        stage('JaCoCo Coverage') {
            steps {
                dir('DevOps_Project') {
                    // Exécutez les tests avec JaCoCo activé
                    sh 'mvn clean verify'

                  
                }
            }
        }

stage('Deploy to Nexus') {
    steps {
        dir('DevOps_Project') {
            sh 'mvn deploy'  
        }
    }
}
stage('SonarQube Analysis') {
    steps {
	 dir('DevOps_Project'){
	sh "mvn sonar:sonar -Dsonar.host.url=${SONARQUBE_URL}"
		}
    }
}



       
    }
}

