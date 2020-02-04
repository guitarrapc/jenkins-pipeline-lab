pipeline {
  agent any
  parameters {
    string(name: "REGEX_TEXT", description: "regex test", defaultValue: "branch1", trim: true)
  }
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

    stage('when regex match') {
      when {
        expression {
          switch (env.REGEX_TEXT) {
            case "master":
              return true
            case ~/^branch[\d]+$/:
              return true
            default:
              return false
          }
        }
      }
      steps {
        // will be skip on normal pipeline
        echo "branch match to master"
      }
    }
  }
}
