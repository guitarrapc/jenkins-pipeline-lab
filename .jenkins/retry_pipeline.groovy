pipeline {
    agent any
    stages {
        stage('hello') {
            steps {
              echo "before retry"
              script {
                def i = 0;
                retry(3) {
                    echo "trying with ${i}."
                    if (i == 0) {
                        echo "failed $i"
                        i++
                        throw new Exception()
                    }
                    echo "success $i"
                }
              }
            }
        }
    }
}
