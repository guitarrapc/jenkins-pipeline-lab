pipeline {
    agent {
        docker "ubuntu:18.04"
    }
    stages {
        stage('hello') {
            steps {
                // sh "uname -a"
                //cat "/proc/version"
                //cat "/etc/lsb-release"
                echo "hello"
                sh returnStdout: true, script: 'cat /etc/lsb-release'
            }
        }
    }
}
