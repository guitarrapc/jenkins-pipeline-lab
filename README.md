jenkins-pipeline-lab

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

