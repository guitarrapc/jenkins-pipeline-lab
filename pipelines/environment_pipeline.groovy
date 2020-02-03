pipeline {
    agent any
    environment {
        FOO = "foo"
        BAR = "bar"
        BASE = "pipeline"
    }
    stages {
        stage('spin up') {
            steps {
                sh "export"
            }
        }
        stage('system env') {
            steps {
                echo "BUILD_ID: ${BUILD_ID}"
                echo "BUILD_TAG: ${BUILD_TAG}"
                echo "BUILD_URL: ${BUILD_URL}"
                echo "GIT_BRANCH: ${GIT_BRANCH}"
                echo "GIT_COMMIT: ${GIT_COMMIT}"
                echo "GIT_URL: ${GIT_URL}"
                echo "JOB_BASE_NAME: ${JOB_BASE_NAME}"
            }
        }
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
