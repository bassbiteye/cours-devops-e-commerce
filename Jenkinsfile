node {
    /* stage('maven def'){
        def mvnHome = tool name: 'Apache Maven 3.6.0', type: 'maven'
        //sh "${mvnHome}/bin/mvn -B -DskipTests clean package"
     } */
     stage('checkout') {
         checkout scm
     }
    stage('Test') {

        //maven: 'maven-3'
        sh './mvnw --version'
        sh 'mvn clean package'
        sh 'mvn test'
    }
    stage('Code Analysis') {
        sh 'mvn clean verify sonar:sonar \
                 -Dsonar.projectKey=devops-tp \
                 -Dsonar.host.url=http://192.168.46.135:9000 \
                 -Dsonar.login=154ba639ee2f917756458407c1aec895aa335467'
    }
}