pipeline {
    agent any
    parameters {
        booleanParam(name: "dry", description: "flag paramter", defaultValue: true)
        string(name: "version", description: "app version", defaultValue: "0.0.1")
    }
    stages {
        stage('hello') {
            steps {
                echo "dry: ${params.dry}"
                echo "version: ${params.version}"
            }
        }
    }
}
