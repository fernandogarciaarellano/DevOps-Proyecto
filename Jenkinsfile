pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                dir("Servicios/Curso-Microservicios") {
                    sh "docker build -t microservicios ."
                }
            }
        }
        stage('DBDeploy') {
            steps {
                sh "docker images"
            }
        }
    }
}