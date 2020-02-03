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

## Pipeline Notes

### generic-pr-trigger_pipeline

trigger pipeline via following command.

```shell
$ curl -X GET -H "Content-Type: application/json" -d '{ "before": "1848f12", "after": "5cab1", "ref": "refs/heads/develop" }' -vs http://admin:admin@localhost:8084/generic-webhook-trigger/invoke?token=1234567890123456789
```

> * note1: `admin:admin@localhost` is `user:password`. you can change to user:token when generated user token.

if you are not using GitHub to trigger generic pipeline, you mya want to use Authorize header like below.

```shell
$ curl -X POST -H "Content-Type: application/json" -H "Authorization:Basic $(echo -n admin:admin | base64)" -H "headerWithNumber: nbr123" -H "headerWithString: a b c" -d '{"eventKey":"repo:refs_changed","date":"2019-04-19T20:52:29+0300","ref":"refs/heads/develop","actor":{"name":"username","emailAddress":"username@domain.com","id":4484,"displayName":"User Name","active":true,"slug":"username","type":"NORMAL","links":{"self":[{"href":"https://stash.mvideo.ru/stash/users/username"}]}},"repository":{"slug":"service-address","id":416,"name":"service-address","scmId":"git","state":"AVAILABLE","statusMessage":"Available","forkable":false,"project":{"key":"RTD","id":310,"name":"RTD","description":"Real Time dealing project","public":false,"type":"NORMAL","links":{"self":[{"href":"https://stash.domain.ru/stash/projects/RTD"}]}},"public":false,"links":{"clone":[{"href":"ssh://git@stash.domain.com/rtd/service-address.git","name":"ssh"},{"href":"https://stash.domain.com/stash/scm/rtd/service-address.git","name":"http"}],"self":[{"href":"https://stash.domain.ru/stash/projects/RTD/repos/service-address/browse"}]}},"changes":[{"ref":{"id":"refs/heads/develop","displayId":"develop","type":"BRANCH"},"refId":"refs/heads/develop","fromHash":"dd20ca964917acc557197c4a0343d8e78804b9bd","toHash":"e48eedc487fea3451526c70c1627fb2b1b242237","type":"UPDATE"}]}' -vs http://localhost:8084/generic-webhook-trigger/invoke?token=1234567890123456789
```
