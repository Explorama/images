FROM eclipse-temurin:20.0.2_9-jdk-alpine

USER root
RUN addgroup -g 901 build
RUN adduser -S -u 901 -G build build

## have required packages in place
RUN apk update \
    && apk add --no-cache bash git zip openssh ncurses gcc gnupg curl make python3 py3-pip jq chromium \
    && apk --no-cache --update add build-base

RUN wget -q "https://github.com/babashka/babashka/releases/download/v1.3.184/babashka-1.3.184-linux-amd64-static.tar.gz" -O bb.tar.gz
RUN tar -xf bb.tar.gz && mv bb /usr/local/bin/bb && rm -f bb.tar.gz
RUN chmod 0755 /usr/local/bin/bb

# Add script to start chromium browser in container with limited environment
COPY --chown=0:0 chromium-docker-launcher.sh /usr/bin/chromium-docker-launcher
RUN chmod 755 /usr/bin/chromium-docker-launcher

# Specify chrome binary for karma
USER build
ENV CHROME_BIN=/usr/bin/chromium-docker-launcher
USER root

## add leiningen
RUN wget -q "https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein" -O /usr/local/bin/lein
RUN chmod 0755 /usr/local/bin/lein

USER build
COPY src/leiningen/profiles.clj /etc/leiningen/profiles.clj
COPY src/leiningen/project.clj /home/build/project.clj

## Install nodejs and npm
USER root
RUN apk add nodejs npm

## Install npm based tooling
# These are required for karma based UI testing and creating license files from npm license checker 
USER root
RUN npm install -g karma@6.4.1 karma-coverage@2.2.0 karma-cli karma-chrome-launcher karma-cljs-test karma-junit-reporter karma-htmlfile-reporter license-checker --save-dev
RUN wget -q "https://raw.githubusercontent.com/borkdude/jet/master/install" -O install-jet
RUN chmod 0755 install-jet
RUN ./install-jet
RUN rm install-jet
USER build


USER root
