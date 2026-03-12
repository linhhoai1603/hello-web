# Sử dụng JRE 21 Alpine siêu nhẹ
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Gradle build xong sẽ tạo file .jar trong thư mục build/libs/
# Ta lấy file có đuôi -SNAPSHOT.jar hoặc file chính (loại bỏ file -plain.jar)
COPY build/libs/*-SNAPSHOT.jar app.jar

# Giới hạn RAM để bảo vệ máy EC2 1GB
ENTRYPOINT ["java", "-Xms128m", "-Xmx512m", "-jar", "app.jar"]

EXPOSE 8080