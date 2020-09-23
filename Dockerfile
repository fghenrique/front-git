FROM openjdk:14
VOLUME /tmp
EXPOSE 7778
ADD ./build/libs/consumir_git-0.0.1-SNAPSHOT.jar consumir_git.jar
ENTRYPOINT ["java","-jar","consumir_git.jar"]