@Library('global-pipeline-libraries')
import com.gpsl.handlers.validateApproval
def validateApproval = new validateApproval()

pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage ('Build Approval') {
            when {
                expression { validateApproval.isBuildUatApproved() }
            }
            steps {
                echo "The build has been approved!!!"
            }
        }
        stage('Build') {
            steps {
                sh 'mvn -X -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    junit skipPublishingChecks: true, testResults:'target/surefire-reports/*.xml'
                }
            }
        }
    }
}