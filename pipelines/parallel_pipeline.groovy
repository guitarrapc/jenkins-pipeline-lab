pipeline {
  agent any
  stages {
    stage('hello') {
      parallel{
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
}
