pipeline {
    agent any
    environment {
        FOO = "foo"
        BAR = "bar"
        BASE = "pipeline"
    }
    stages {
        stage('hello') {
            steps {
                echo "FOO: ${FOO}"
                echo "BAR: ${BAR}"
                echo "BASE: ${BASE}"
            }
        }

        stage('STAGE OVERRIDE') {
            environment {
                BASE = "stage"
            }
            steps {
                echo "BASE: ${BASE}"
            }
        }
    }
}
