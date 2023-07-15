FROM apache/hadoop:3

WORKDIR /opt/hadoop

COPY start-namenode.sh .

RUN sudo chmod a+x start-namenode.sh

RUN mkdir -p scripts samples jars dfs/name dfs/data yarn/timeline