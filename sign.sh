#!/usr/bin/env bash

# This script signs the all .jar files in **/jar/*.jar

for jar in $(find . -name "*.jar"); do
    if [[ $jar == *"/jar/"* ]]; then
        echo "Signing $jar"
        jarsigner -keystore keystore.jks -storepass 123456 $jar server

        echo "Verifying $jar"
        jarsigner -verify -keystore keystore.jks $jar server
    fi
done