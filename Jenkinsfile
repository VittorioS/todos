pipeline {
    agent any
    stages {
        stage('Build') {
            stages {
                stage('Maven') {
                    agent { docker { image 'maven:3.8.5-openjdk-18-slim' } }
                    steps {
                        // Run Maven on a Unix agent.
                        sh "mvn -Dmaven.test.failure.ignore=true -DskipTests clean install"
                    }
                }
                stage('Docker') {
                    stages {
                        stage('Docker/Clean') {
                            agent any
                            steps {
                                script {
                                    try {
                                        // Remove container
                                        sh "docker rm -f -v todos_backend"
                                        // Remove image
                                        sh "docker rmi todos:latest"
                                    } catch (err) {
                                        echo "${err}"
                                    }
                                }
                            }
                        }
                        stage('Docker/Build') {
                            agent any
                            steps {
                                // Build docker image
                                sh "docker build -f docker/Dockerfile -t todos:latest ."
                            }
                        }
                    }
                }
            }
        }
        stage('Deploy') {
            agent any
            steps {
                // Run container
                sh "docker run --rm --detach -p 8080:8080 --name todos_backend todos:latest"
            }
        }
    }
}
