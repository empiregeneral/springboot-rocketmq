# RocketMQ使用过的问题记录

在Linux环境下部署Rockmq有不少注意点，一个配置错误即导致使用RocketMQ失败



## 1. 环境部署的参数变量的设置

在Linux环境下默认安装了是java rpm或deb包，请在安装完成后在环境变量中自动export JAVA_HOME

不然调用rockmq的tools.sh中mqadmin脚本时会报错，莫名其妙的错误：

```
Caused by: org.apache.rocketmq.acl.common.AclException: [10015:signature-failed] unable to calculate a request signature. error=Algorithm HmacSHA1 not available
```

产生的原因是找不到JAVA_HOME/lib/ext/sunjce_provider.jar的文件

注意：mqadmin手动创建topic有用

具体创建命令为：

```
bash -x mqadmin updateTopic -b 192.168.2.234:9876 -t string-topic
```

Windows环境下要和Linux环境下的mq正常通信的话，需要设置和Linux环境下下同样的/etc/hosts值



## 2. 先启动namesrv再启动broker

1. 启动namesrv:

   ```
   bash -xe mqnamesrv
   ```

  2.设置broker.properties

  ```
echo "brokerIP1=192.168.2.234" > broker.properties
  ```

  3.启动broker

  ```
bash ./mqbroker -n 192.168.2.234:9876 autoCreateTopicEnable=true -c broker.properties
  ```



## 3. 可以启动docker部署rocketmq服务

在github中下载[rocketmq-docker](https://github.com/apache/rocketmq-docker.git)，然后自动打包docker镜像，启动rocketmq集群服务。

简要操作步骤：

```
cd rocketmq-docker
bash stages.sh 4.5.0
cd ./stages/4.5.0
bash -xe play-docker-compose.sh
```

当然还有很多启动方式都以play*.sh脚本为开头。

部署完成 rocketmq集群后可以启动rocketmq-console查看消息队列的可视化界面。

可以用命令：**java -Djava.security.egd=file:/dev/./urandom -jar rocketmq-console-ng-2.0.0.jar &** 启动rocketmq监控页面。

Docker启动后也有不少的坑，通过命令创建topic失败等。



## 4. Linux环境下启动Rocketmq步骤

1. 启动namesrv: **bash -x bin/mqnamesrv &**

2. 启动broker: **bash -x bin/mqbroker -n <mqnamesrvAddr> -c  <pathofbroker.properties> autoCreateTopicEnable=true**

3. 调用创建topic命令来验证: **bash -x mqadmin updateTopic -b 192.168.2.234:9876 -t string-topic**

   日志显示success即创建topic成功。

   



