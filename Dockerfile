FROM oracle/graalvm-ce:20.1.0-java8 as graalvm
RUN gu install native-image

COPY . /home/app/micronaut2
WORKDIR /home/app/micronaut2

RUN native-image --no-server -cp build/libs/micronaut2-*-all.jar

FROM frolvlad/alpine-glibc
RUN apk update && apk add libstdc++
EXPOSE 8080
COPY --from=graalvm /home/app/micronaut2/micronaut2 /app/micronaut2
ENTRYPOINT ["/app/micronaut2"]
