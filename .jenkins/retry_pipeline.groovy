pipeline {
    agent any
    stages {
        stage('hello') {
            steps {
              echo "before retry"
              retry(5) {
                echo 'retrying up to 5 times, if fails.'
              }
            }
        }
    }
}
