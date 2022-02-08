node {
    stage('Test') {
        sh './mvnw test'
    }
    stage('Code Analysis') {
        sh './mvnw clean verify sonar:sonar \
                 -Dsonar.projectKey=devops-tp \
                 -Dsonar.host.url=http://localhost:9000 \
                 -Dsonar.login=fa54d39d485b05e03c45ae768a9e262cedd864e4'
    }
}