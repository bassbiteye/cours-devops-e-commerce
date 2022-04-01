pipeline{
    agent any
    
    
    
    stages{
        stage('Get source'){
            steps{
                git(
                url:"https://github.com/bassbiteye/cours-devops-e-commerce.git",
                credentialsId: "TESTISI",
                branch:"dev");
            }
        }
  
    stage('build') {
            steps{
                
                bat 'mvn clean install'
                
            }
            
        }
        
        stage('Units Tests') {
        steps {
        bat 'mvn test'
         }
        }
        
         stage('scan') {
            steps{
                withSonarQubeEnv(installationName:'sqk'){
                    bat 'mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.7.0.1746:sonar'
                }
                
            }

        }
     
     stage('jfog') {
        steps{
            rtServer (
                id:"Artifactory",
                url:"http://localhost:8082/artifactory",
                username:"admin",
                password:"Passer@157829",
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
