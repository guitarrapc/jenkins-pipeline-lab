pipeline {
    agent any
    stages {
        stage('hello') {
            steps {
              echo "before retry"
              script {
                for (job in ['a', 'b', 'c']) {
                  retry(3) {
                    echo 'retrying up to 5 times, if fails.'
                    if (job != "c") {
                        throw new Exception()
                    }
                  }
                }
              }
            }
        }
    }
}
