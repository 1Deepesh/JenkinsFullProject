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
        string (name: 'BRANCH', defaultValue: '')
    }
    stages {
        stage('LoadConfigFiles') {
            steps {
                script {
                    sh "pwd"
                    setDeployEnv = load ('src/main/groovy/setDeployEnv.groovy')
                }
            }
        }

        stage('app-config files') {
            steps {
                script {
                    cleanWs()
                    def GIT_APP_URL = "https://github.com/1Deepesh/hello-world.git"
                    params.GIT_APP_URL = GIT_APP_URL                 
                    checkout([$class: 'GitSCM', branches: [[name: "$BRANCH_NAME"]], extensions: [], gitTool: 'Default', userRemoteConfigs: [[credentialsId: "$GITLAB_CREDENTIALS", url: "$APP_GIT_URL"]]])
                }
            }
        }
            
        
        stage('printEnvVars') {
            steps {
                script {
                    print ("The application name is : $APP_NAME")
                }
            }
        }
    }
}