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
        sh './mvnw clean package'
    }
    stage('Test') {
        sh './mvnw test'
    }
    stage('Code Analysis') {
        sh './mvnw clean verify sonar:sonar \
                 -Dsonar.projectKey=devops-tp \
                 -Dsonar.host.url=http://192.168.0.109:9000 \
                 -Dsonar.login=154ba639ee2f917756458407c1aec895aa335467'
    }
}