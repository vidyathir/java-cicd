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
                echo '<------------- Build completed --------------->'
            }
        }
        stage('Unit Test') {
            steps {
                echo '<--------------- Unit Testing started  --------------->'
                echo '<------------- Unit Testing stopped  --------------->'
            }
        }
    }
}

