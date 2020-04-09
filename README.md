# 运行步骤
1、在`MySQL`中，创建名为`goods`的数据库
```shell script
# 在Docker中创建名为goodMysql容器的MySQL数据库
docker run --name goodMysql -p 3307:3306 -e MYSQL_ROOT_PASSWORD=root -d mysql
# 进入刚创建的MySQL数据库
docker exec -it goodMysql mysql -uroot -p
# 输入密码：root

# 创建goods数据库
CREATE DATABASE goods;
```

2、初始化表结构和数据
```shell script
mvn flyway:clean
mvn flyway:migrate
```

3、启动应用后，进入如下地址：
```shell script
http://localhost:8080/html/index.html
```