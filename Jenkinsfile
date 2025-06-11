pipeline {
    agent any

    tools {
        maven 'Maven 3'
        jdk 'Java 17'
    }

    environment {
        SPRING_PROFILES_ACTIVE = "test"
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/barssim/openAPI.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }

        stage('Package') {
            steps {
                sh 'mvn package'
            }
        }

        stage('Run') {
            steps {
                sh 'java -jar target/*.jar &'
            }
        }
    }

    post {
        always {
            echo 'Pipeline finished.'
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed!'
        }
    }
}
