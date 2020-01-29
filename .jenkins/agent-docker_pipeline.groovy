pipeline {
    agent {
        docker "ubuntu:18.04"
    }
    stages {
        stage('hello') {
            steps {
                script{
                    echo "hello"
                    sh "cat /proc/version"
                    sh "cat /etc/lsb-release"
                    sh "uname -a"
                    // do not run like `cat /proc/version`. you will recieve cat not found.
                }
            }
        }
    }
}
