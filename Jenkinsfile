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
            sh "./mvnw sonar:sonar"
        }
    }
}
