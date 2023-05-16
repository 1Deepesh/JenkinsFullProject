pipeline {
    agent any 
    environment {
        APP_NAME = "demo1"
    }
    // params
    parameters {
        string (name: 'GIT_APP_URL', defaultValue: '')
        string (name: 'APP_CONFIG_DIR', defaultValue: '')
        string (name: 'CONFIG_DIR', defaultValue: 'DevOps')
        string (name: 'DEPLOY_ENVIRONMENT', defaultValue: '')
        string (name: 'EMAIL_TO', defaultValue: 'deepesh.prasad@cummins.com')
    }
    stages {
        stage('a') {
            steps {
                script {
                    println ("The Branch You are Working on is - $BRANCH_NAME")
                }
            }
        }
    }
}