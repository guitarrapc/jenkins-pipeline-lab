pipeline {
    agent {
        docker "ubuntu:18.04"
    }
    stages {
        stage('hello') {
            steps {
                // sh "uname -a"
                echo "hello"
                cat "/etc/lsb-release"
                cat "/proc/version"
                cat "/etc/lsb-release"
            }
        }
    }
}
