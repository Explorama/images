#!/usr/bin/env sh

Xvfb :0 -screen 0 1920x1080x24 -ac +extension GLX +render -noreset &
# no-sandbox option may be omited in case user is properly set up in container
# see https://developers.google.com/web/updates/2017/04/headless-chrome
# and https://github.com/ebidel/lighthouse-ci/blob/master/builder/Dockerfile#L35-L40
DISPLAY=:0.0 chromium-browser --disable-gpu --no-sandbox $@
killall Xvfb
