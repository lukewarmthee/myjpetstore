package org.csu.mypetstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//在此项目运行文件也要打开包扫描,以便找到接口同xml配置文件进行bound产生包含方法的class文件
@MapperScan("org.csu.mypetstore.persistence")
public class MypetstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MypetstoreApplication.class, args);
    }

}
