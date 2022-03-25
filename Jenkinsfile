node {
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
    /* stage('Tomcat Deployment') {
        sh './mvnw tomcat7:deploy'
    } */
    stage ('Server'){
        steps {
           rtServer (
             id: "Artifactory",
             url: 'http://localhost:8046/artifactory',
             username: 'admin1',
              password: 'Passer123',
              bypassProxy: true,
               timeout: 300
                    )
        }
    }
    stage('Upload'){
        steps{
            rtUpload (
             serverId:"Artifactory" ,
              spec: '''{
               "files": [
                          {
                          "pattern": "*.war",
                          "target": "logic-ops-lab-libs-snapshot-local"
                          }
                        ]
                       }''',
                    )
        }
    }
    stage ('Publish build info') {
        steps {
            rtPublishBuildInfo (
                serverId: "Artifactory"
            )
        }
    }
}