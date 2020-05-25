pipeline {
  agent any
  stages {
    stage('1.success') {
      steps {
        sh 'exit 0'
      }
    }
    stage('2.error&continue') {
      steps {
        catchError(buildResult: 'SUCCESS', stageResult: 'FAILURE') {
          sh "exit 1"
        }
      }
      post {
        success {
          echo "post success: inside stage"
        }
        failure {
          echo "post failure: inside stage"
        }
      }
    }
    stage('3.success') {
      steps {
          sh 'exit 0'
      }
    }
  }
}
