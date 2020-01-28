pipeline {
    agent any
    stages {
        stage('hello') {
            steps {
              echo "before retry"
              script {
                for (job in ['a', 'b', 'c']) {
                  retry(3) {
                    echo "retrying for $job."
                    if (job != 'c') {
                        echo "failed $job"
                        throw new Exception()
                    }
                    echo "success $job"
                  }
                }
              }
            }
        }
    }
}
