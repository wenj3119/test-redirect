FROM registry-sy.xcloud.lenovo.com/xcloud-lmp/skywalking-agent-xcloud-base:openjdk-11-8.8.0-debian11

MAINTAINER wenjun4 <wenjun4@lenovo.com>

RUN mkdir -p /data/server/

ADD ./test-redirect-0.0.1-SNAPSHOT.jar /data/server/app.jar

ENV SW_SERVICE_PATH_NAME capp.jar

ENV SW_AGENT_NAME test

ENV SW_AGENT_COLLECTOR_BACKEND_SERVICES 127.0.0.1:30000

RUN chmod +x  /data/server/app.jar

ENTRYPOINT ["/bin/bash","docker-entrypoint.sh"]
