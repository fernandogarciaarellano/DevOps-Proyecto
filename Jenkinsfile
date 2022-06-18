pipeline {
    agent any

    stages {
        stage('Validate') {
            steps {
               dir("Servicios/Curso-Microservicios") {
                    withSonarQubeEnv('SonarQubeServer') {
                        sh "mvn clean install sonar:sonar \
                            -Dsonar.projectKey=22_MyCompany_Microservice \
                            -Dsonar.projectName=22_MyCompany_Microservice \
                            -Dsonar.sources=src/main \
                            -Dsonar.coverage.exclusions=**/*TO.java,**/*DO.java,**/curso/web/**/*,**/curso/persistence/**/*,**/curso/commons/**/*,**/curso/model/**/* \
                            -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml"
                    }
                } 
            }
        }
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