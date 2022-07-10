pipeline {
    agent any
    stages {
      stage('maven install') {
        steps {
       withMaven(maven:'maven_3_6_0') {
           sh 'mvn clean install'
       }
        }
      }

    }
}