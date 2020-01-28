pipeline {
    agent any
    stages {
        stage('hello') {
            steps {
                sh "./scripts/hello.sh"
            }
        }
    }
}
