# IDEA编译spring-framework

## 环境

开发工具： IntelliJ IDEA 2020.3

操作系统： windows 10

Spring版本：spring-framework-5.2.0.release

## 编译

1. 下载Spring源码

   访问Spring官方源码地址 https://github.com/spring-projects/spring-framework
   
   下载源码zip包到本地并解压

2. build.gradle配置镜像

    1. buildscript中添加镜像

       ```
       repositories {
           maven{ url 'https://maven.aliyun.com/nexus/content/groups/public/' }
           maven{ url 'https://maven.aliyun.com/nexus/content/repositories/jcenter'}
       }
       ```

    2. dependencyManagement下repositories中添加镜像

       ```
       repositories {
           maven { url 'https://maven.aliyun.com/nexus/content/groups/public/'}
           maven { url 'https://maven.aliyun.com/nexus/content/repositories/jcenter'}
           mavenCentral()
           maven { url "https://repo.spring.io/libs-spring-framework-build" }
       }
       ```

3. 预编译

   gradlew :spring-oxm:compileTestJava

![image-20210505133959145](https://gitee.com/cf_9909/image_bed/raw/master/images/image-20210505133959145.png)

4. 导入Spring源码至IntelliJ IDEA

   将之前下载好的Spring源码解压后导入到IDEA，依次点击File->Open，选择源码包路径下的build.gradle文件完成源码导入

![image-20210505134306915](https://gitee.com/cf_9909/image_bed/raw/master/images/image-20210505134306915.png)

![image-20210505135119883](https://gitee.com/cf_9909/image_bed/raw/master/images/image-20210505135119883.png)

接下来要对idea进行设置（非必须），不然每次idea运行都会通过gradle去编译运行——gradle运行编译特别慢；改成idea自己编译运行

![image-20210505135623589](https://gitee.com/cf_9909/image_bed/raw/master/images/image-20210505135623589.png)

自此，编译的整个过程已经完成。下面我们要做的事就是添加自己的模块对已编译的项目模块进行验证测试

## 测试

![image-20210505135740508](https://gitee.com/cf_9909/image_bed/raw/master/images/image-20210505135740508.png)

![image-20210505135915439](https://gitee.com/cf_9909/image_bed/raw/master/images/image-20210505135915439.png)

建好项目之后在gradle的配置文件中添加spring的依赖

![image-20210505141005133](https://gitee.com/cf_9909/image_bed/raw/master/images/image-20210505141005133.png)

### 代码

配置类

```java
@Configuration
@ComponentScan("com.simplefanc")
public class AppConfig {
}
```

组件类

```java
@Component
public class AppService {
}
```

测试类（获取bean）

```java
public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println(context.getBean(AppService.class));
	}
}
```

### 结果

![image-20210505145056420](https://gitee.com/cf_9909/image_bed/raw/master/images/image-20210505145056420.png)

### 问题

1. 找不到符号 类InstrumentationSavingAgent

![](https://gitee.com/cf_9909/image_bed/raw/master/images/20210505154946.png)

   首先找到报错这个类所在的项目（如DefaultContextLoadTimeWeaver类所在的项目为spring-context）；
   再看看out文件夹（idea默认编译文件为out）下面是不是有这个class

   解决：**可以运行这个项目下面的测试类test**让idea去帮我们编译这些java类

   遇到其他这类问题也可类似这种办法解决

2. 缺少 cglib 和 objenesis 包
   Kotlin: warnings found and -Weeror specified

![image-20210505144351667](https://gitee.com/cf_9909/image_bed/raw/master/images/image-20210505144351667.png)

​		解决：双击以下两个jar

![image-20210505143804502](https://gitee.com/cf_9909/image_bed/raw/master/images/image-20210505143804502.png)



参考：

1. https://github.com/spring-projects/spring-framework/wiki/Build-from-Source
2. https://github.com/spring-projects/spring-framework/blob/main/import-into-idea.md
3. https://blog.csdn.net/java_lyvee/article/details/107300648
4. https://blog.csdn.net/zjssoul/article/details/110939030
