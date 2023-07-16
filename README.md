# hadoop-sandbox

sandbox project for diginamic classes on hadoop

## Prerequisites

- [docker](https://docs.docker.com/install/)

## Getting started

- build the playground (in the playground directory)

```bash
./mvnw clean package
```

- build required images (in the root directory)

```bash
make cluster
```

- Start the cluster (in the root directory, use **make run** instead to run in foreground)

```bash
make up
```

## Test the cluster

- check status of the cluster (in the root directory)

```bash
make status
```

- peek at a running container's logs (replace **CONTAINER_NAME**)

```bash
docker container logs CONTAINER_NAME
```

- test in a browser
  - [cluster health](http://localhost:9870) - namenode
  - [yarn](http://localhost:8088) - resourcemanager
  - [filesystem status](http://localhost:3141/status) - playground

### MapReduce

- Connect to the cluster (most useful volumes are mounted in the resourcemanager container)

```bash
docker exec -it resourcemanager bash
```

- create a file containing any text (in the resourcemanager container)

```bash
echo "hello world !" > input.txt
```

- copy the created file to hdfs (in the resourcemanager container)

```bash
hdfs dfs -put input.txt
```

- run wordcount on the added file (in the resourcemanager container, should display the result)

```bash
yarn jar archives/playground.jar wordcount /input.txt output && \
hdfs dfs -cat output/part-r-00000
```

### HBase

## Clean up

- Stop the cluster (in the root directory)

```bash
make stop
```

- reset the cluster (in the root director)

```bash
make reset
```
