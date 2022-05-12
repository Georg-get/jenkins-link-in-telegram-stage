stage("Sending a message in Telegram chat") {
    steps {
        withCredentials([usernamePassword(credentialsId: 'telegram_bak', usernameVariable: 'ChatId', passwordVariable: 'TokenId')]) {
            sh """
                curl -s -X POST https://api.telegram.org/bot[${TokenId}]/sendMessage -d chat_id=[${ChatId}] -d text="Новый релиз репы ${GIT_REPO_NAME} , ветки ${BRANCH_NAME}"
                """
            }
        }