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
          echo "post failure: error happen"
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
