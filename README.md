# give-up-halfway
Trying to build an interesting website. And maybe give up halfway.

# 项目说明
pokeball 是 nginx 分发静态资源(html, js)的项目，里面没啥，可以放个配置啥的。前端静态资源在 eating-fish 那个项目里。   
rolling-machine 是 beginner 项目，挑战用基础工具做后端，甚至在手拼 String。  
faucet 是自动部署服务器，监听 github 的 webhook，所有 push 到 github master 和符合一定条件的代码都会自动构建镜像然后部署。随手搭的，会覆盖之前的，报错也没有反馈。希望能早日用上好的 CD 工具。  
可以自己写服务，开个新的文件夹当个新项目就行了，前端也一样。

## 启动
可以直接写完代码推到 github 上，记得 commit 信息里加上 lets go! （含叹号），然后就会推上去了，会自己构建然后部署。  

有问题的话 ssh 到部署的机器去查看 zya 目录下的 log 现在可视化啥的都没做，因为没有用好工具。。。  

本机启动：docker-compose up (没试过，原理上应该可以)  
或者建个 swarm 集群然后 stack deploy，怎么打 tag 写在 faucet 里。
