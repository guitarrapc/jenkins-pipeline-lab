pipeline {
  agent {
    docker "mcr.microsoft.com/dotnet/sdk:5.0"
  }
  // in case you don't want use Webhook, use SCM polling.
  // this polling will trigger to all remoteACM Repository URLs associated with your build, including
  // the URLs specified by checkout steps,
  // the URL of your Declarative Pipeline script from SCM,
  // and the URL of your Global Pipeline Libraries.
  triggers {
      pollSCM 'H/10 * * * *'
  }
  parameters {
    string(name: 'BRANCH', defaultValue: 'master', description: 'GitHub branch to build.')
  }
  environment {
    HOME = '/tmp' // prevent error when dotnet restore on docker. "Access to the path '/.dotnet' is denied. ---> System.IO.IOException: Permission denied"
    DOTNET_CLI_TELEMETRY_OPTOUT = 1
    DOTNET_SKIP_FIRST_TIME_EXPERIENCE = 1
    NUGET_XMLDOC_MODE = "skip"
  }
  options {
    skipDefaultCheckout()
    timestamps()
  }
  stages {
    stage('spin up') {
      steps {
        sh "export"
      }
    }
    stage('checkout') {
      steps {
        checkout(
          changelog: true,
          poll: true, /*This is the important option to poll this repo change*/
          scm: [
              $class: 'GitSCM',
              branches: [[name: "*/${BRANCH}"]], // leave blank to check all branches
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
        sh "dotnet restore ./src/SkiaSharp.QrCode/"
        sh "dotnet build ./src/SkiaSharp.QrCode/ -c Debug"
        sh "dotnet test ./tests/SkiaSharp.QrCode.Tests.net50/ -c Debug -p:CollectCoverage=true -p:CoverletOutputFormat=opencover"
      }
    }
    stage('samples') {
      steps {
        sh "dotnet build ./samples/ManualGenerate/ -c Debug"
        sh "dotnet run --project ./samples/ManualGenerate/ManualGenerate.csproj -c Debug -f net5.0"
        sh "dotnet build ./samples/SimpleGenerate/ -c Debug"
        sh "dotnet run --project ./samples/SimpleGenerate/SimpleGenerate.csproj -c Debug -f net5.0"
      }
    }
  }
}
