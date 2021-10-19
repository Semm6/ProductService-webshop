FROM openjdk:11
EXPOSE 8085
ADD target/productservice-shop.jar productservice-shop.jar
ENTRYPOINT ["java", "-jar", "/productservice-shop"]
