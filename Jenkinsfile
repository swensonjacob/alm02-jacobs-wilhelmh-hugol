pipeline {

    agent any
    stages {
        stage('Build'){
           steps {
            echo 'Building'
            sh 'mvn clean install'
            sh 'ls'
           }
           post{
               always {
                   junit 'target/surefire-reports/*.xml'

                      publishHTML([
                       allowMissing: false,
                       alwaysLinkToLastBuild: false,
                       keepAll: false,
                       reportDir: 'target/surefire-reports/',
                       reportFiles: 'index.html',
                       reportName: 'Jacoco Coverage Report',
                       reportTitles: 'Jacoco Report'
                    ])

                   publishHTML([
                       allowMissing: false,
                       alwaysLinkToLastBuild: false,
                       keepAll: false,
                       reportDir: 'target/site/',
                       reportFiles: 'index.html',
                       reportName: 'Jacoco Coverage Report',
                       reportTitles: 'Jacoco Report'
                    ])
               }
           }
        }
        stage('Test'){
            steps {
                echo 'Testing'
                sh 'mvn test'
            }
        }
        stage('Deploy'){
            steps {
                echo 'Deploying'
                sh 'mvn spring-boot:run'
                sh 'mvn -v'

            }
            post {
                always {
                    echo 'Saving artifacts...'
                    archiveArtifacts artifacts: 'target/*.war', onlyIfSuccessful: true
                }
            }
        }
    }
}