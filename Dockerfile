FROM openjdk:8
COPY ./src/TestGraph/DisplayGraph.java/ /tmp
WORKDIR /tmp
ENTRYPOINT ["java","Graph"]