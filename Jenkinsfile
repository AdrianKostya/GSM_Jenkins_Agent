pipeline {
    agent any
    stages {
      stage('maven install') {
        steps {
       withMaven(maven:'maven') {
           sh 'mvn clean install'
       }
        }
      }

    }
}