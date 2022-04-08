
node {
    stage('Get source') {
        checkout scm
    }

    stage('check java version') {
        sh "java -version"
    }

    dir(""){

        stage('Unit test') {
            sh "chmod +x ./mvnw"
            sh "./mvnw test"
        }

         stage('Quality code') {
            sh "./mvnw clean verify sonar:sonar \
                  -Dsonar.projectKey=tp-devops-e-commerce \
                  -Dsonar.host.url=http://127.0.0.1:9000 \
                  -Dsonar.login=b94abbcbdecd2e8b51170btr7ca196461aba2f8"
        }

        stage('packaging') {
            sh "./mvnw verify -DskipTests"
            archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
        }

        stage('Tomcat Localy Deployment') {
            sh './mvnw tomcat7:deploy'
        }

        stage ('Connexion Artifactory Server'){
            steps {
               rtServer (
                 id: "Artifactory",
                 url: 'http://localhost:8046/artifactory',
                 username: 'admin',
                  password: 'passer',
                  bypassProxy: true,
                   timeout: 300 )
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
}
