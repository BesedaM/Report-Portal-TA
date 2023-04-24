pipeline{

agent any

    stages{
        stage('Checkout SCM'){
            steps{
                echo 'Downloading project code'
                     withCredentials([gitUsernamePassword(credentialsId: "${GIT_CREDENTIALS_ID}", gitToolName: 'git-tool')]) {
                          script {
                              currentBuild.displayName = "#${BUILD_NUMBER}"
                              checkout_project()
                          }
                     }
                }
            }
        stage('Build'){
            steps{
                echo 'Build project'
                }
            }
        stage('Run API tests'){
            steps{
                echo 'Running API tests'
                }
            }
        stage('Run UI tests'){
            steps{
                echo 'Running UI tests'
                }
            }
        }
}