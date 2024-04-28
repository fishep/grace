# docker

> 在docker部署服务和应用

# docker 常用指令

```shell
docker inspect redis | grep IPAddress
docker exec -it alpine bash

docker-compose -p grace up -d

docker manifest create fishep/alpine:latest fishep/alpine:arm64 fishep/alpine:amd64
docker manifest push fishep/alpine:latest
docker manifest rm fishep/alpine:latest


docker run -it --privileged --pid=host --name=change_count debian nsenter -t 1 -m -u -n -i sh
sysctl -w vm.max_map_count=2000000

docker-compose -p grace -f docker-compose-amd64.yaml up -d
docker-compose -p grace -f docker-compose-arm64.yaml up -d

```

