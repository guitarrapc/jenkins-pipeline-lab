pipeline {
  agent any
  parameters {
    string(name: "ref", defaultValue: "")
  }
  triggers {
    GenericTrigger(
      genericVariables: [
        [key: 'ref', value: '$.ref']
      ],

      causeString: 'Triggered on $ref',
      token: '1234567890123456789',

      printContributedVariables: true,
      printPostContent: true,
      silentResponse: false,

      regexpFilterText: '$ref',
      regexpFilterExpression: 'refs/heads/.*'
    )
  }
  stages {
    stage('hello') {
      steps {
        echo 'REF $ref'
      }
    }
  }
}
