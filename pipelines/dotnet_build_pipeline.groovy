pipeline {
  agent {
    docker "mcr.microsoft.com/dotnet/sdk:5.0"
  }
  parameters {
    string(name: 'BRANCH', defaultValue: 'master', description: 'GitHub branch to build.')
  }
  options {
    skipDefaultCheckout()
    timestamps()
  }
  stages {
    stage('checkout') {
      steps {
        checkout(
          changelog: true,
          poll: true, /*This is the important option to poll this repo change*/
          scm: [
              $class: 'GitSCM',
              branches: [[name: "*/$env.BRANCH"]], // leave blank to check all branches
              doGenerateSubmoduleConfigurations: false,
              extensions: [
                [$class: 'CleanCheckout'], // clean before checkout
                //[$class: 'RelativeTargetDirectory', relativeTargetDir: "src/"], // checkout to "src" folder
                [$class: 'CloneOption', depth: 1, noTags: false, reference: '', shallow: true] // shallow clone with depth 1
              ],
              submoduleCfg: [],
              userRemoteConfigs: [[url: 'https://github.com/guitarrapc/SkiaSharp.QrCode.git']]
            ]
        )
      }
    }
    stage('build') {
      steps {
        sh "dotnet --version"
        sh """
          pwd
          ls -l
        """
        dir("src/") {
          sh """
            pwd
            ls -l
          """
        }
      }
    }
  }
}
