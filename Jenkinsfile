node {
    stage('Test') {
    sh 'export MAVEN_HOME=/var/jenkins_home/maven/apache-maven-3.6.3
        export PATH=$PATH:$MAVEN_HOME/bin
        mvn --version
        mvn clean package'
        sh 'mvn test'
    }
    stage('Code Analysis') {
        sh './mvnw clean verify sonar:sonar \
                 -Dsonar.projectKey=devops-tp \
                 -Dsonar.host.url=http://192.168.46.135:9000 \
                 -Dsonar.login=154ba639ee2f917756458407c1aec895aa335467'
    }
}