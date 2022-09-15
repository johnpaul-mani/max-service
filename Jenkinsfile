@Library('global-pipeline-libraries')_
import com.gpsl.GlobalVars

pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }
    stages {
        stage ('Health Check') {
            steps {
                healthCheck 'health status'
                println GlobalVars.foo
                echo "Health Check Complete!!!"
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