/* 
    This code will help in setting the environment variables for Jenkins pipeline as per their environments 
*/

def readEnvVariables() {
    dir('DevOps') {
        // load generic environment vars 
        // if application.yml file exists then only run

        if (fileExists('application.yml')) {
        def configVars = readYaml file: "application.yml"
        config = configVars.environment
        config.each { key, value -> env."$key" = value }

        
        }
        // if environment specific yaml files exists, then load them
        if ((BRANCH.equals('main')) && (fileExists('application-dev.yml'))) {
            def devConfigVars = readYaml file: "application-dev.yml"
            config_dev = prodConfigVars.environment 
            config_dev.each { key, value -> env."$key" = value}
        }

        else if ((BRANCH.equals('stage')) && (fileExists('application-stage.yml'))) {
            def stageConfigVars = readYaml file: "application-stage.yml"
            config_stage = stageConfigVars.environment 
            config_stage.each { key, value -> env."$key" = value }
        }

        else if ((BRANCH.equals('prod')) && (fileExists('application-prod.yml'))) {
            def prodConfigVars = readYaml file: "application-prod.yml"
            config_prod = prodConfigVars.environment 
            config_prod.each { key, value -> env."$key" = value}
        }
    }
}

