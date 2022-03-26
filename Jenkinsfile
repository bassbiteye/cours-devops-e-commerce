pipeline{
    agent any

    tools {
        maven 'apache-maven-3.8.4'
    }

    stages{
        stage('Get source'){
            steps{
                git(
                url:"https://github.com/bassbiteye/cours-devops-e-commerce.git",
                credentialsId: "github_test_ISI_id",
                branch:"dev");
            }
        }

        stage('Units Tests') {
        steps {
        bat 'mvn test'
        }


}
     stage('sonar test'){
         steps{
             bat 'mvn clean verify sonar:sonar \
  -Dsonar.projectKey=projetdvops \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=11f183b381c32480dd649bd6d11a25fad3408cc3'
         }
     }

     stage('jfog') {
        steps{
            rtServer (
                id:"Artifactory",
                url:"http://localhost:8046/artifactory",
                username:"",
                password:"",
                bypassProxy:true,
                timeout:300

                )
        }
        }
       stage('Upload') {
        steps{
            rtUpload (
                serverId:"Artifactory",
               spec: '''{
                   "files":[
                       {
                           "pattern":"*.war",
                           "target": "projetdevopsofficiel-libs-snapshot-local"
                       }
                       ]
               }''',

            )
        }
        }
        stage('Publish build info') {
        steps{
            rtPublishBuildInfo (
                serverId:"Artifactory"

                )
        }
        }

    }


}
