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
        always {
          echo "post always: inside stage"
        }
        // changed means when the build status is different than the previous build's status.
        changed {
          echo "post changed: inside stage"
        }
        // success, failure, unstable all run if the current build status is successful, failed, or unstable, respectively
        success {
          echo "post success: inside stage"
        }
        failure {
          echo "post failure: inside stage"
        }
        unstable {
          echo "post unstable: inside stage"
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
