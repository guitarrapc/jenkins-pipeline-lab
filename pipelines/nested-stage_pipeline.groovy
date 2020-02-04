pipeline {
  agent any
  stages{
    stage('nest1') {
      stages {
        stage('hello1-1') {
          steps {
            echo "hello1"
          }
        }
        stage('hello1-2'){
          steps {
              echo "hello2"
          }
        }
      }
    }
    stage('nest2') {
      stages {
        stage('hello2-1') {
          steps {
            echo "hello1"
          }
        }
        stage('hello2-2'){
          steps {
              echo "hello2"
          }
        }
      }
    }
  }
}
