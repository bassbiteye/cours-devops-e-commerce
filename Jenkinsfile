node {
    stage('Get source') {
        checkout scm
    }

    stage('check java version') {
        sh "java -version"
    }

    dir(""){

        stage('Unit test') {
            sh "chmod +x ./mvnw"
            sh "./mvnw test"
        }

        stage('packaging') {
            sh "./mvnw verify -DskipTests"
            archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
        }

         /*stage('Quality code') {
            sh "./mvnw clean verify sonar:sonar \
                  -Dsonar.projectKey=cours-devops-e-commerce \
                  -Dsonar.host.url=http://172.17.0.2:9000 \
                  -Dsonar.login=b94abbcbdecd2e8b51170b74b0ca196461aba2f8"
        }*/
    }
}
