pipeline {
    agent {
        docker { image 'node:7-alpine' }
    }
    stages {
        stage('Test') {
            steps {
                sh(returnStdout: true, script: 'node --version')
            }
        }
    }
}
