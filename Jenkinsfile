pipeline {
    agent any
    tools {
            maven 'Maven3'

        }
    stages {
      stage('maven install') {
        steps {
        sh 'mvn -Dmaven.test.failure.ignore=true install'
       withMaven() {
           sh 'mvn clean install'
       }
        }
      }

    }
}