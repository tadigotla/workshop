#!/usr/bin/env sh

wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add -

sh -c 'echo "deb [arch=amd64] http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list'

# Install google chrome
apt-get update && apt-get install -yq google-chrome-stable

# Install imagemagick
apt-get install -yq xvfb imagemagick

mkdir -p /tmp
cd /tmp
wget https://chromedriver.storage.googleapis.com/2.44/chromedriver_linux64.zip

unzip chromedriver_linux64.zip
