pipeline {
    agent any
    tools {
        maven 'M3_9_10'
        jdk 'jdk-17'
    }

    stages {
        // stage('Validate') {
        //     steps {
        //         dir("servicios/CursoMicroservicios") {
        //             withSonarQubeEnv('SonarServer') {
        //                 sh "mvn clean install sonar:sonar \
        //                     -Dsonar.projectKey=25_MyCompany_Microservice \
        //                     -Dsonar.projectName=25_MyCompany_Microservice \
        //                     -Dsonar.sources=src/main \
        //                     -Dsonar.coverage.exclusions=**/*TO.java,**/*DO.java,**/curso/web/**/*,**/curso/persistence/**/*,**/curso/commons/**/*,**/curso/model/**/* \
        //                     -Dsonar.coverage.jacoco.xmlReportPaths=target/site/jacoco/jacoco.xml"
        //             }
        //         }
        //     }
        // }
        stage('Compile') {
            steps {
                dir("servicios/CursoMicroservicios") {
                    sh "docker build -t curso-microservicios ."
                }
            }
        }
        stage('Push Image') {
            steps {
                withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'docker_nexus', usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD']]) {
                    sh 'docker login 192.168.0.26:8083 -u $USERNAME -p $PASSWORD'
                    sh 'docker push microservicio:latest'

                }
            }
        }
    }
}
