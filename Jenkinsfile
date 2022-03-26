node {
    /* stage('maven def'){
        def mvnHome = tool name: 'Apache Maven 3.6.0', type: 'maven'
        //sh "${mvnHome}/bin/mvn -B -DskipTests clean package"
     } */
     stage('checkout') {
         checkout scm
     }
    stage('Maven Version') {
        sh './mvnw --version'
    }
    stage('Maven clean package') {
        sh './mvnw clean package -DskipTests'
    }
    stage('Test') {
        sh './mvnw test'
    }
    stage('Code Analysis') {
        sh './mvnw sonar:sonar \
                 -Dsonar.projectKey=devops-tp \
                 -Dsonar.host.url=http://localhost:9000 \
                 -Dsonar.login=46d48dfabf4fce7267719eba191d6a4774e6d5bc'
    }
}