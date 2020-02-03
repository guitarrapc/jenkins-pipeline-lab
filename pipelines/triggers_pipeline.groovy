pipeline {
    agent any

    options {
        quietPeriod(30)
    }
    triggers {
        //cron('H */4 * * 1-5') // Build periodically
        pollSCM('H/10 * * * *') // Poll SCM
    }
    stages {
        stage('hello') {
            steps {
                echo 'hello world'
            }
        }
    }
}
