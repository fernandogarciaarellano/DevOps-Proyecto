pipeline {
    agent any
    tools {
        maven 'M3_9_10'
    }

    stages {
        stage('Validate') {
            steps {
                dir("servicios/CursoMicroservicios") {
                    withSonarQubeEnv('SonarServer') {
                        sh "mvn clean install sonar:sonar \
                            -Dsonar.projectKey=25_MyCompany_Microservice \
                            -Dsonar.projectName=25_MyCompany_Microservice \
                            -Dsonar.sources=src/main \
                            -Dsonar.coverage.exclusions=**/*TO.java,**/*DO.java,**/curso/web/**/*,**/curso/persistence/**/*,**/curso/commons/**/*,**/curso/model/**/* \
                            -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml"
                    }
                }
            }
        }
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
