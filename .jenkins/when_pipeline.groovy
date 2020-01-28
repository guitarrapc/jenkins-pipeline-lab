pipeline {
    agent any
    environment {
        BASE = "pipeline"
    }
    stages {
        stage('when environment not match') {
            steps {
                echo "BASE: ${BASE}"
            }

            when {
                environment name: "BASE", value: "stage"
            }
        }

        stage('when environment match') {
            environment {
                BASE = "stage"
            }
            when {
                environment name: "BASE", value: "stage"
            }
            steps {
                echo "BASE: ${BASE}"
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
                branch "master"
            }
            steps {
                echo "branch match to master"
            }
        }
    }
}
