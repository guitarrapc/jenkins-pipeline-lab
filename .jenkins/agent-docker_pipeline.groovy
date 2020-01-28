pipeline {
    agent {
        docker "ubuntu:18.04"
    }
    stages {
        stage('hello') {
            steps {
                script{
                    echo "hello"
                    cat "/proc/version"
                    cat "/etc/lsb-release"
                    // sh "uname -a"
                }
            }
        }
    }
}
