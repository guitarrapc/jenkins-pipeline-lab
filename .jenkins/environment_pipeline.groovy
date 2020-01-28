pipeline {
    agent any
    environment {
        FOO = "foo"
        BAR = "bar"
    }
    stages {
        stage('hello') {
            steps {
                echo 'FOO: ${FOO}'
                echo 'BAR: ${BAR}'
            }
        }
    }
}
