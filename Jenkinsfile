pipeline {
    agent any
    tools {
            maven 'Maven 3.6.0'
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