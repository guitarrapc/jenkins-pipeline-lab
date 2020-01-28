pipeline {
    agent any
    stages {
        stage('hello') {
            steps {
                parallel(
                  firstBlock: {
                    echo "hello1"
                  },
                  secondBlock: {
                    echo "hello2"
                  }
                )
            }
        }
    }
}
