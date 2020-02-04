pipeline {
  agent any
  stage('nest') {
    stages {
      stage('hello1') {
        steps {
          echo "hello1"
        }
      }
      stage('hello2'){
        steps {
            echo "hello2"
        }
      }
    }
  }
}
