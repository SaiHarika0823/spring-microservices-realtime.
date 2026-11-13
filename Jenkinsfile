pipeline {
    agent any

    stages {
        stage('Build Service Registry') {
            steps {
                dir('Service_registry') {
                    bat './mvnw.cmd clean package -DskipTests'
                }
            }
        }
        stage('Build First Microservice') {
            steps {
                dir('first-microservice') {
                    bat './mvnw.cmd clean package -DskipTests'
                }
            }
        }
        stage('Build Second Microservice') {
            steps {
                dir('second-microservice') {
                    bat './mvnw.cmd clean package -DskipTests'
                }
            }
        }
cd /c/Users/Admin/Documents/workspace-spring-tools-for-eclipse-4.31.0.RELEASE
git checkout develop

cat << 'EOF' > Jenkinsfile
pipeline {
    agent any

    stages {
        stage('Build Service Registry') {
            steps {
                dir('Service_registry') {
                    bat './mvnw.cmd clean package -DskipTests'
                }
            }
        }
        stage('Build First Microservice') {
            steps {
                dir('first-microservice') {
                    bat './mvnw.cmd clean package -DskipTests'
                }
            }
        }
        stage('Build Second Microservice') {
            steps {
                dir('second-microservice') {
                    bat './mvnw.cmd clean package -DskipTests'
                }
            }
        }
        stage('Build API Gateway') {
            steps {
                dir('api_gateway') {
                    bat './mvnw.cmd clean package -DskipTests'
                }
            }
        }
    }
}
