pipeline {
  agent any
  environment {
    BASE = "pipeline"
  }
  stages {
    stage('spin up') {
      steps {
          sh "export"
      }
    }

    stage('when environment not match') {
      when {
        environment name: "BASE", value: "pipeline"
      }

      steps {
        echo "BASE: ${BASE}"
      }
    }

    stage('when environment match') {
      // when evaluate before environment
      when {
        environment name: "BASE", value: "stage"
      }
      environment {
        BASE = "stage"
      }
      steps {
        echo "BASE: ${BASE}"
        script {
          // never run
          throw new Exception()
        }
      }
    }

    stage('when expression bool') {
      when {
        expression { return true }
      }
      steps {
        echo "expression"
      }
    }

    stage('when branch master') {
      when {
        // only ran when multibranch pipeline. it will never trigger on normal pipeline.
        branch "master"
      }
      steps {
        // will be skip on normal pipeline
        echo "branch match to master"
      }
    }
  }
}