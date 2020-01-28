pipeline {
    agent any
    stages {
        stage('hello') {
            steps {
                sh "./scripts/hello.sh"
                script{
                    OS = sh returnStdout:true, script: "uname -a"
                    echo ${OS}
                }
            }
        }
    }
}
