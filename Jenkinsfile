pipeline{
    agent any
     tools {
        maven "maven-3.8.4"
    }
    stages{

        stage('Get source'){
           steps{
                git(
                url:"https://github.com/bassbiteye/cours-devops-e-commerce.git",
                credentialsId: "github_id_isi",
                branch:"fournisseur");
            }
        }
       stage('Build'){
            steps{
                bat 'mvn clean package'
            }
         }
           stage('test'){
            steps{
                bat 'mvn test'
            }
         }
       stage('SonarQube analysis') {
//    def scannerHome = tool 'SonarScanner 4.0';
        steps{
        withSonarQubeEnv('sonarqube-9.2.1') {
        // If you have configured more than one global server connection, you can specify its name
//      sh "${scannerHome}/bin/sonar-scanner"
        bat "mvn sonar:sonar"
    }
        }
        }
 stage('jfog') {
        steps{
            rtServer (
                id:"Artifactory",
                url:"http://localhost:8046/artifactory",
                username:"admin",
                password:"Passer@123",
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
                           "target": "ecommerce-libs-snapshot-local"
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