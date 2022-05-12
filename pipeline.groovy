#!groovy
properties([disableConcurrentBuilds()]) //запрет на паралейные сборки
pipeline {
    options {
        buildDiscarder(logRotator(numToKeepStr: '10', artifactNumToKeepStr: '10', daysToKeepStr: '2', artifactDaysToKeepStr: '2'))
        timestamps()
    }

    stage("build") {
        stage {
            sh  """
                """
        }
    }    

    stage("test") {
        stage {
            sh  """
                """
        }
    }

    stage("sonar") {
        stage {
            sh  """
                """
        }
    }

    stage("build docker image") {
        stage {
            sh  """
                """
        }
    }

    stage("deploy") {
        stage {
            sh  """
                """
        }
    }

    stage("Sending a message in Telegram chat") {
        steps {
            withCredentials([usernamePassword(credentialsId: 'telegram_bak', usernameVariable: 'ChatId', passwordVariable: 'TokenId')]) {
                sh """
                    curl -s -X POST https://api.telegram.org/bot[${TokenId}]/sendMessage -d chat_id=[${ChatId}] -d text="Новый релиз репы ${GIT_REPO_NAME} , ветки ${BRANCH_NAME}"
                    """
                }
            }   
    }
}