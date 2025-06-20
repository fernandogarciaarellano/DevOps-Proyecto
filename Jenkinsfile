pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                dir("servicios/CursoMicroservicios") {
                    sh "docker build -t curso-microservicios ."
                }
            }
        }
        stage('Deploy') {
            steps {
                sh "docker images | grep curso-microservicios"
            }
        }
    }
}
