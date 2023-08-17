# Maven

## Maven介绍

Maven项目对象模型(POM)，可以通过一小段描述信息来管理项目的构建，报告和[文档](https://baike.baidu.com/item/文档/1009768)的[项目管理工具](https://baike.baidu.com/item/项目管理工具/6854630)软件。

为什么学习Maven

新建、编写、发布一个web项目可能会遇到的问题：

1、新建项目时。不同IDE编写web项目时，项目的文件夹结构是有区别的。

2、需要在lib文件夹下添加依赖（jar）。

​	 a、手动保存需要使用的jar文件。

​	b、手动记录所有jar包依赖关系。

​	c、jar包之间的版本冲突也需要人工记忆。

​	d、每个项目都需要n多重复的jar包，会导致硬盘有很多重复的复制品。

3、可以管理多模块。

4、项目如果没有ide就无法进行编译、打包、发布。

![image-20210419142727406](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419142727.png)



项目构建和管理依赖



## Maven的安装与配置

### 1、下载

https://maven.apache.org/download.cgi

![image-20210419143102590](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419143102.png)

### 2、安装

解压缩

![image-20210419143224669](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419143224.png)

### 3、配置环境变量

配置MAVEN_HOME

![image-20210419143413525](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419143413.png)

配置Maven的命令，path路径

![image-20210419143544592](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419143544.png)

### 4、验证maven是否配置完成

```bash
mvn-version
```

![image-20210419143715150](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419143715.png)

### 5、在maven中配置本地仓库

![image-20210419143937411](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419143937.png)

![image-20210419144044350](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419144044.png)

### 6、配置镜像

```
<mirror>
		<id>alimaven</id>
		<mirrorOf>central</mirrorOf>
		<name>aliyun maven</name>
		<url>http://maven.aliyun.com/nexus/content/groups/public/</url>
	</mirror>
```



### 7、初始化仓库

![image-20210419144222732](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419144222.png)





## Maven核心概念介绍

### 1、手动编写一个maven项目

```
src
	main		#源程序
		java	#java代码
		resource	#配置文件
	test		#测试程序
		java	#测试代码
		resource	#测试配置文件
pom.xml		#项目的描述
```

pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
	
    <!--
 		项目描述
		groupId公司名称  com.xxxx
		artifactId项目名称
		version版本号

		统称为坐标
		将他们组合起来就是项目在Maven本地仓库发布的位置
	-->
    <groupId>com.woniu</groupId>
    <artifactId>Maven45</artifactId>
    <version版本号>1.0-SNAPSHOT</version>
    
    <!--
		管理依赖
		<groupId>javax.servlet</groupId>
        <artifactId>javax.servlet-api</artifactId>
        <version>3.1.0</version>
		通过坐标在本地仓库查找该jar包，如果没有，则按照镜像网址查找，并下载到本地仓库
	-->
    <dependencies>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
        </dependency>
    </dependencies>
</project>
```



## Maven常用命令	

### 1、查看版本号

```bash
mvn -version
```

### 2、初始化仓库

```bash
mvn help:sysetem
```

### 3、清除编译后的内容

```bash
mvn clean #删除target目录
```

### 4、编译java源代码

```
mvn compile
```

### 5、运行测试代码

```
mvn test
```

### 6、对Maven项目打包

```
mvn package
```

默认maven项目是jar类型

如果需要打成war包，则在pom.xml添加配置

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.woniu</groupId>
    <artifactId>Maven45</artifactId>
    <version>1.0-SNAPSHOT</version>
    <!--
    	声明当前项目类型是war类型。
    	需在main中声明webapp/WEB-INF/web.xml。
    -->
	<packaging>war</packaging>
    <dependencies>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
        </dependency>
		<!-- https://mvnrepository.com/artifact/junit/junit -->
		<dependency>
			<groupId>junit</groupId>
			<artifactId>junit</artifactId>
			<version>4.12</version>
			<scope>test</scope>
		</dependency>

    </dependencies>
</project>
```

### 7、将当前项目发布到本地仓库

```
mvn install
```

可以通过该项目的坐标在本地仓库中引用该jar文件。



## Maven生命周期

### 1、clean生命周期：清理项目，包含三个phase。

1）pre-clean：执行清理前需要完成的工作

2）clean：清理上一次构建生成的文件

3）post-clean：执行清理后需要完成的工作

### **2、default生命周期**：构建项目，重要的phase如下。

1）validate：验证工程是否正确，所有需要的资源是否可用。
2）compile：编译项目的源代码。  
3）test：使用合适的单元测试框架来测试已编译的源代码。这些测试不需要已打包和布署。
4）Package：把已编译的代码打包成可发布的格式，比如jar。
5）integration-test：如有需要，将包处理和发布到一个能够进行集成测试的环境。
6）verify：运行所有检查，验证包是否有效且达到质量标准。
7）install：把包安装到maven本地仓库，可以被其他工程作为依赖来使用。
8）Deploy：在集成或者发布环境下执行，将最终版本的包拷贝到远程的repository，使得其他的开发者或者工程可以共享。

### 3、site生命周期：建立和发布项目站点，phase如下

1）pre-site：生成项目站点之前需要完成的工作

2）site：生成项目站点文档

3）post-site：生成项目站点之后需要完成的工作

4）site-deploy：将项目站点发布到服务器



## IDE工具集成Maven

### 1、进行新项目的配置

![image-20210419165952036](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419165952.png)

![image-20210419170020873](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419170020.png)

![image-20210419170209379](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419170209.png)

### 2、新建Maven项目

![image-20210419170349118](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419170349.png)

![image-20210419170511794](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419170511.png)

![image-20210419170905569](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419170905.png)

### 3、运行war项目

![image-20210419171009541](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419171009.png)

![image-20210419171209436](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419171209.png)

![image-20210419171246834](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419171246.png)

![image-20210419171338482](https://woniumd.oss-cn-hangzhou.aliyuncs.com/java/panfeng/20210419171338.png)



