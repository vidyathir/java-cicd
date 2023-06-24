def buildJar() {
    echo "building the application..."
    sh 'mvn package'
}

def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t thirug01/simple-web:2.0.2 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push thirug01/simple-web:2.0.2'
    }
}
