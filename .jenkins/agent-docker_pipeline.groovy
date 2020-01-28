pipeline {
    agent {
        docker "ubuntu:18.04"
    }
    stages {
        stage('hello') {
            steps {
                // sh "uname -a"
                // sh "cat /etc/lsb-release"
                // sh "cat /proc/version"
                // sh "cat /etc/lsb-release"
                echo hello
            }
        }
    }
}
