node {
    stage('checkout') {
        checkout scm
    }

    stage('check java version') {
        sh "java -version"
    }

    dir(""){
        stage('clean') {
            sh "chmod +x ./mvnw"
            sh "./mvnw clean"
        }
    }
    stage('Build Prod') {
        //when {branch 'fournisseur'}
        sh './mvnw clean verify -DskipTests'
    }
}