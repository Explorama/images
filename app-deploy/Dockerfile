FROM electronuserland/builder:wine
# Install make and npm, also zip and unzip just in case
RUN apt-get update \
    && apt-get install -y curl software-properties-common \
    && curl -sL https://deb.nodesource.com/setup_18.x | bash - \
    && apt-get install -y make nodejs zip unzip gcc g++ \
    && npm install -g electron-packager

RUN dpkg --add-architecture i386 && apt remove wine -y && apt remove wine-stable -y && rm -rf ~/.wine/
RUN apt install wine -y
