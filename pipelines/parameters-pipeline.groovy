pipeline {
  agent any
  parameters {
    booleanParam(name: "dry", description: "flag paramter", defaultValue: true)
    string(name: "version", description: "app version", defaultValue: "0.0.1", trim: true)
    text(name: "message", description: "text message", defaultValue: "long way run to the home")
    choice(name: "choice", choices: ["One", "Two", "Three"], description: "choice your favorite") // defaultValue is not allowed
    password(name: "password", description: "your secret", defaultValue: "SECRET")
  }
  stages {
    stage('hello') {
      steps {
        echo "bool: dry -> ${params.dry}"
        echo "string: version -> ${params.version}"
        echo "text: message -> ${params.message}"
        echo "choice: choice -> ${params.choice}"
        echo "password: password -> ${params.password}"
      }
    }
  }
}
