pipeline {

     agent any
     stages {
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'mvn clean install'
            }

        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'mvn test'
                sh 'mvn surefire-report:report-only'
            }

        }

        stage ('Publish') {

            steps {
                echo 'Publishing Test Reports'
            }

            post {
                always {
                        publishHTML([
                            allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            keepAll: false,
                            reportDir: 'target/site/',
                            reportFiles: 'surefire-report.html',
                            reportName: 'Unit Tests',
                            reportTitles: 'Unit Tests'
                        ])

                        publishHTML([
                            allowMissing: false,
                            alwaysLinkToLastBuild: false,
                            keepAll: false,
                            reportDir: 'target/site/jacoco/',
                            reportFiles: 'index.html',
                            reportName: 'Test coverage',
                            reportTitles: 'Test coverage'
                        ])
                }
            }
        }

        stage('Saving artifacts') {
            steps {
                echo 'Saving war file ...'
        }
            post {
                always {
                    echo 'Saving artifacts..'
                    archiveArtifacts artifacts: 'target/*.war', onlyIfSuccessful: true
                }
            }
        }
     }
}