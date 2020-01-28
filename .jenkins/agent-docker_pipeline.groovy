pipeline {
    agent {
        docker "ubuntu:18.04"
    }
    stages {
        stage('hello') {
            steps {
                script {
                    uname -a
                    cat /etc/lsb-release
                    cat /proc/version
                    cat /etc/lsb-release
                }
            }
        }
    }
}
