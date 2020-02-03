pipeline {
  agent any
  stages {
    stage('ubuntu') {
      agent {
        docker "ubuntu:18.04"
      }
      steps {
        script{
          echo "hello"
          sh "cat /proc/version"
          sh "cat /etc/lsb-release"
          sh "uname -a"
        }
      }
    }
    stage('alpine') {
      agent {
          docker "alpine:latest"
      }
      steps {
        script{
          echo "hello"
          sh "cat /proc/version"
          sh "cat /etc/alpine-release"
          sh "uname -a"
        }
      }
    }
    stage('checkout') {
      agent {
        docker "ubuntu:18.04"
      }
      options {skipDefaultCheckout()}
      steps {
        step([$class: 'WsCleanup'])
        checkout scm
        sh "ls -la"
        sh "hostname"
        sh "pwd"
        sh "touch hoge"
      }
    }
  }
}
