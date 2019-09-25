package com.springmvc.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.springmvc.entity.Hello;
import com.springmvc.service.HelloService;
import com.springmvc.utils.BeanUtil;
import com.springmvc.utils.JsonUtil;
import com.springmvc.utils.PagedResult;
import com.springmvc.utils.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ：qmf
 * @date ：Created in 2019/8/24 10:26
 * @description：
 * @modified By：
 */
@RestController
@RequestMapping("/test")
public class TestController {

    private Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private HelloService helloService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping(value = "/hello", produces = "application/json;charset=UTF-8")
    public PagedResult hello(String pageNo, String pageSize) {
        Hello hello = new Hello();
        int pageN = StringUtils.isEmpty(pageNo) ? 1 : Integer.parseInt(pageNo);
        int pageP = StringUtils.isEmpty(pageSize) ? 20 : Integer.parseInt(pageSize);
        PageHelper.startPage(pageN, pageP);//关键步骤
        PageInfo<Hello> page = null;
        try {
            List<Hello> select = helloService.select(hello);
            String p = redisUtil.get("hello-list");
            log.info("缓存中数据为：" + p);
            if (p == null) {
                redisUtil.set("hello-list", JsonUtil.objectToJson(select));
                redisUtil.expire("hello-list", 30, TimeUnit.SECONDS);
                log.info("放入缓存成功...");
            }
            page = new PageInfo<Hello>(select);
            log.info("哈哈");
        } catch (Exception e) {
            log.info(e + "");
        }
        return BeanUtil.toPagedResult(page);
    }

    @RequestMapping(value = "/insert", produces = "application/json;charset=UTF-8")
    public int insert() {
//        for (int i = 0; i < 100; i++) {
//            Hello s = new Hello();
//            s.setName("啥" + i);
//            helloService.insert(s);
//        }
        Hello hello = new Hello();
        hello.setName("[mysqld]\n" +
                "#服务端口号 默认3306\n" +
                "port=3306\n" +
                "#内部内存临时表的最大值 ，设置成128M。\n" +
                "#比如大数据量的group by ,order by时可能用到临时表，\n" +
                "#超过了这个值将写入磁盘，系统IO压力增大\n" +
                "max_heap_table_size=1024M\n" +
                "tmp_table_size=1024M\n" +
                "character_set_server=utf8\n" +
                "init_connect='SET NAMES utf8'\n" +
                "#mysql安装根目录\n" +
                "basedir=/usr/local/mysql\n" +
                "#mysql数据文件所在位置\n" +
                "datadir=/usr/local/mysql/data\n" +
                "#设置socke文件所在目录\n" +
                "socket=/tmp/mysql.sock\n" +
                "log-error=/var/log/mysqld.log\n" +
                "pid-file=/var/run/mysqld/mysqld.pid\n" +
                "#是否对sql语句大小写敏感，1表示不敏感\n" +
                "lower_case_table_names = 1\n" +
                "#最大连接数\n" +
                "max_connections=5000[mysqld]\n" +
                "#服务端口号 默认3306\n" +
                "port=3306\n" +
                "#内部内存临时表的最大值 ，设置成128M。\n" +
                "#比如大数据量的group by ,order by时可能用到临时表，\n" +
                "#超过了这个值将写入磁盘，系统IO压力增大\n" +
                "max_heap_table_size=1024M\n" +
                "tmp_table_size=1024M\n" +
                "character_set_server=utf8\n" +
                "init_connect='SET NAMES utf8'\n" +
                "#mysql安装根目录\n" +
                "basedir=/usr/local/mysql\n" +
                "#mysql数据文件所在位置\n" +
                "datadir=/usr/local/mysql/data\n" +
                "#设置socke文件所在目录\n" +
                "socket=/tmp/mysql.sock\n" +
                "log-error=/var/log/mysqld.log\n" +
                "pid-file=/var/run/mysqld/mysqld.pid\n" +
                "#是否对sql语句大小写敏感，1表示不敏感\n" +
                "lower_case_table_names = 1\n" +
                "#最大连接数\n" +
                "max_connections=5000");
        hello.setId(1999L);
        try {
            helloService.insert(hello);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }


}
