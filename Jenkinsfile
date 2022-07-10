pipeline {
    agent any
    stages {
      stage('maven install') {
        steps {
       withMaven(maven:'maven 3.6.0') {
           sh 'mvn clean install'
       }
        }
      }

    }
}