pipeline {
  agent any

  // https://jenkins.io/doc/book/pipeline/syntax/#options
  options {
    // General Jenkins job properties
    buildDiscarder(logRotator(numToKeepStr:'1'))
    // Declarative-specific options
    skipDefaultCheckout()
    // "wrapper" steps that should wrap the entire build execution
    timestamps()
    timeout(time: 5, unit: 'MINUTES')
    // retry pipeline when failed
    retry(3)
  }

  stages {
    stage('hello') {
      options {
        timeout(time: 1, unit: 'HOURS')
      }
      steps {
        echo 'hello world'
      }
    }
  }
}
