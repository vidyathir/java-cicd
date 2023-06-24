
pipeline {
    agent {
       node {
         label "worker1"
      }
    }
    stages {
        stage('Build') {
            steps {
                echo '<--------------- Building --------------->'
                sh 'printenv'
                sh 'mvn clean deploy -Dmaven.test.skip=true'
                echo '<------------- Build completed --------------->'
            }
        }
        stage('Unit Test') {
            steps {
                echo '<--------------- Unit Testing started  --------------->'
                sh 'mvn surefire-report:report'
                echo '<------------- Unit Testing stopped  --------------->'
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image" 
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                         sh 'docker build -t thirug01/simple-web:2.0.2 .'
                         sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push thirug01/simple-web:2.0.2'
                      }
                    
                }
            }
        } 
    }        
}
    

