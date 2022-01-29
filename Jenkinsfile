node {
    stage('checkout') {
        checkout scm
    }

    stage('check java') {
        sh "java -version"
    }

    dir(""){
        stage('clean') {
            sh "chmod +x ./mvnw"
            sh "./mvnw clean"
        }
    }
}
