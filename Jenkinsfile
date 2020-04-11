pipeline {
    agent any
    tools { 
        maven 'Maven' 
        jdk 'Java' 
    }
    stages {
        stage ('Initialize') {
            steps {
                bat '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                ''' 
            }
        }

         stage ('Maven Build') {
            steps {
                bat 'mvn clean install' 
            }
        }
        
         stage ('Docker Build') {
            steps {
                bat 'docker build -t peterhell95/books:jenkins .' 
            }
        }
        
        stage ('Docker Login') {
            steps {
                bat 'docker login -u peterhell95 -p Negro123Negro' 
            }
        }
        
        stage ('Docker Push') {
            steps {
                bat 'docker push peterhell95/books:jenkins' 
            }
        }
        
        stage('Deploy Patient App') {
    	steps {
        withCredentials([
            string(credentialsId: 'my_kubernetes2', variable: 'api_token')]) {
             bat 'kubectl apply -f books-deployment.yaml '
               }
            }
        }
    }
}