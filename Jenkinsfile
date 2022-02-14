node {
    /* stage('maven def'){
        def mvnHome = tool name: 'Apache Maven 3.6.0', type: 'maven'
        //sh "${mvnHome}/bin/mvn -B -DskipTests clean package"
     } */
    stage('Test') {
//         sh 'export MAVEN_HOME=/var/jenkins_home/maven/apache-maven-3.6.3'
//         sh 'export PATH=$PATH:$MAVEN_HOME/bin'
        withMaven(
            // Maven installation declared in the Jenkins "Global Tool Configuration"
            maven: 'maven-3', // (1)
            // Use `$WORKSPACE/.repository` for local repository folder to avoid shared repositories
            //mavenLocalRepo: '.repository', // (2)
            // Maven settings.xml file defined with the Jenkins Config File Provider Plugin
            // We recommend to define Maven settings.xml globally at the folder level using
            // navigating to the folder configuration in the section "Pipeline Maven Configuration / Override global Maven configuration"
            // or globally to the entire master navigating to  "Manage Jenkins / Global Tools Configuration"
            //mavenSettingsConfig: 'my-maven-settings' // (3)
        )
        sh 'mvn --version'
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