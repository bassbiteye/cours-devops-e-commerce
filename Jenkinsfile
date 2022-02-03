node {
    stage('checkout') {
        checkout scm
    }

    stage('check java version') {
        sh "java -version"
    }

    dir(""){
        stage('build') {
            sh "chmod +x ./mvnw"
            sh "./mvnw clean package"
        }

         stage('SonarQube Analyse') {
            sh "chmod +x ./mvnw"
            sh "./mvnw clean verify sonar:sonar \
                  -Dsonar.projectKey=cours-devops-e-commerce \
                  -Dsonar.host.url=http://localhost:9000 \
                  -Dsonar.login=b94abbcbdecd2e8b51170b74b0ca196461aba2f8"
        }
    }
}
