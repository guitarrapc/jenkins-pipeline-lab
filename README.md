jenkins-pipeline-lab

## Plugin

* Generic Webhook Trigger Plugin: https://github.com/jenkinsci/generic-webhook-trigger-plugin

## Lint

```shell
$ npm install -g jflint
$ cat <<EOF >> ~/.jflintrc
{
  "jenkinsUrl": "http://your-jenkins.example.com",
  "username": "USERNAME",
  "password": "PASSWORD"
}
EOF
$ jflint ./.jenkins/echo_pipeline.groovy
```

