pipeline {
    agent any
    stages {
        stage('build') {
            steps {
                sh 'mvn clean install -Dmaven.test.skip=true'
            }
        }

        stage('test') {
            steps {
                sh 'mvn test -Dspring.profiles.active=test'
            }
        }
    }
}