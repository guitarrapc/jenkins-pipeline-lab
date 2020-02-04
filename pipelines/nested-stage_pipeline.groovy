pipeline {
  agent any
  stages {
    stage('next') {
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
