// vars/pushToDockerHub.groovy
def call(String credentialsId, String imageName, String tag) {
    withCredentials([usernamePassword(credentialsId: credentialsId, usernameVariable: 'DockerHubUsername', passwordVariable: 'DockerHubPassword')]) {
        sh "docker login -u ${DockerHubUsername} -p ${DockerHubPassword}"
        sh "docker image tag ${imageName}:latest ${DockerHubUsername}/${imageName}:${tag}"
        sh "docker push ${DockerHubUsername}/${imageName}:${tag}""
    }
}
