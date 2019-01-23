## Deployment and more than deployment

Http Server listening to github hooks and local .git hooks.

## build images
The official docker hub is too slow building the images. Build it on private server and push it to testing and deployment.

## docker 原生部署系统
听说 docker 原生的 swarm 比 kubernetes 简单很多。先试试 docker swarm。  
### docker service 一些坑
publish ports: 如果用 host mode 会映射到运行的节点上，默认是映射到 ingress 网络上。如果已经在监听会启动失败。
deploy: 用 global mode 会在所有节点上启动仅一个副本，用 placement.constraints 或者 placement.preferences 约束，默认是自动分配副本，集群自己会做负载均衡。  
官方文档说起一个 registry 服务来做不同节点的镜像同步，否则还要在每个节点搞同步，不能接受。但是这样仓库 port 会暴露在 ingress 网络上，不知道有没有更优雅便捷的的做法。  

## 部署
按理说每个节点都要注明 usedfor label，
因为节点全部用 usedfor 区分，usedfor =  
 * nginx: 跑 pokeball 的节点
 * api: 跑 rolling-machine 的节点
 * deploy: docker 仓库
现在 faucet 没有加进节点里，所以它不能自己部署自己。不太想认真搞这个 faucet，基本不会变。
