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
                script {
                    echo "BASE: ${BASE}"
                }
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
                // never run
                throw new Exception()
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
                branch "origin/master"
            }
            steps {
                echo "branch match to master"
            }
        }
    }
}
