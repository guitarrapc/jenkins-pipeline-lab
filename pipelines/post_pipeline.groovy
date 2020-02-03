pipeline {
    agent any
    stages {
        stage('hello') {
            steps {
                echo 'hello world'
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
    }

    post {
        always {
            echo "post always: after stage"
        }
        // changed means when the build status is different than the previous build's status.
        changed {
            echo "post changed: after stage"
        }
        // success, failure, unstable all run if the current build status is successful, failed, or unstable, respectively
        success {
            echo "post success: after stage"
        }
        failure {
            echo "post failure: after stage"
        }
        unstable {
            echo "post unstable: after stage"
        }
  }
}
