pipeline {
    agent any

    environment {
        IMAGE_NAME = "spring-gradle-app"
        CONTAINER_NAME = "spring-server"
    }

    stages {
        stage('Cleanup') {
            steps {
                sh "docker rm -f ${CONTAINER_NAME} || true"
                sh "docker image prune -f"
            }
        }

        stage('Build with Gradle') {
            steps {
                echo 'Đang Build ứng dụng bằng Gradle...'
                // Cấp quyền thực thi cho file chạy Gradle
                sh 'chmod +x gradlew'
                // Build file JAR, bỏ qua test để tiết kiệm RAM và thời gian
                sh './gradlew clean bootJar -x test'
            }
        }

        stage('Docker Build') {
            steps {
                sh "docker build -t ${IMAGE_NAME} ."
            }
        }

        stage('Deploy') {
            steps {
                // Map port 80 của máy ảo vào 8080 của ứng dụng
                sh "docker run -d --name ${CONTAINER_NAME} -p 80:8080 ${IMAGE_NAME}"
            }
        }
    }

    post {
        success {
            echo "Tuyệt vời! Truy cập ngay http://${env.PUBLIC_IP_EC2} (Cổng 80)"
        }
    }
}