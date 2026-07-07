# 第一阶段：构建阶段 (可选，如果你已经在本地打包好jar，可以跳过此阶段直接使用第二阶段)
# 使用 JDK 21 进行编译，确保编译环境与运行环境一致
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# 设置工作目录
WORKDIR /app

# 复制 pom.xml 和源码
COPY pom.xml .
COPY src ./src

# 构建项目，跳过测试以加快构建速度（生产环境建议保留测试）
RUN mvn clean package -DskipTests

# 第二阶段：运行阶段
# 使用 Eclipse Temurin (Adoptium) 的 JDK 21 JRE 精简版作为基础镜像
# Temurin 是 OpenJDK 的高质量发行版，对容器化支持良好
FROM eclipse-temurin:21-jre-alpine

# 设置维护者信息 (可选)
LABEL maintainer="your-email@example.com"

# 设置工作目录
WORKDIR /app

# 从构建阶段复制生成的 JAR 文件
# 注意：根据你的实际项目名称修改 jar 包名称
COPY --from=builder /app/target/demo-0.0.1-SNAPSHOT.jar app.jar

# 暴露应用端口 (假设 Spring 应用运行在 8080 端口)
EXPOSE 9080

# 设置 JVM 参数以优化容器环境
# -XX:+UseContainerSupport: 让 JVM 识别容器内存限制
# -XX:MaxRAMPercentage=75.0: 使用容器内存的 75% 作为堆内存
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# 启动应用
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]