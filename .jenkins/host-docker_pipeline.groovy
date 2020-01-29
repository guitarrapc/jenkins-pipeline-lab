pipeline {
    agent any
    stages {
        stage('hello') {
            steps {
                sh "docker run hello-world"
            }
        }
    }
}
