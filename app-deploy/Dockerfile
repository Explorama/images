FROM electronuserland/builder:wine
# Install make and npm, also zip and unzip just in case
RUN apt-get update \
    && apt-get install -y curl software-properties-common \
    && apt-get install -y make nodejs zip unzip gcc g++ zstd \
    && npm install -g electron-packager

RUN dpkg --add-architecture i386 && apt remove wine -y && apt remove wine-stable -y && rm -rf ~/.wine/
RUN apt install wine -y
RUN apt install openjdk-17-jre -y

## add leiningen
RUN wget -q "https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein" -O /usr/local/bin/lein
RUN chmod 0755 /usr/local/bin/lein

COPY src/leiningen/profiles.clj /etc/leiningen/profiles.clj
