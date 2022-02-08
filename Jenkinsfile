node {
    stage('Test') {
        sh './mvnw test'
    }
    stage('Code Analysis') {
        sh './mvnw sonar:sonar'
    }
}