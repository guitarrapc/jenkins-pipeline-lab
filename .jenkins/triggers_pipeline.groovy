pipeline {
    agent any

    options {
        quietPeriod(30)
    }
    triggers {
        cron('H */4 * * 1-5')
        //pollSCM('H/10 * * * *')
    }
    stages {
        stage('hello') {
            steps {
                echo 'hello world'
            }
        }
    }
}
