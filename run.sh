#!/bin/bash
# Convenience script to run the app with the correct JDK
export JAVA_HOME="/c/Users/nlozanoc/.jdk/jdk-25"
export PATH="$JAVA_HOME/bin:$PATH"
./mvnw spring-boot:run "$@"
