package com.alone.test;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName CodeGenerator 代码生成器
 * @Author zzzzwwwwwwwwwwwwww
 * @Date 2021/2/24 23:47
 * @Description CodeGenerator
 * @Version 1.0
 */
public class CodeGenerator {
    public static void main(String[] args) {
        // 需要构建一个 代码自动生成器 对象
        AutoGenerator mpg = new AutoGenerator();
// 配置策略

// 1、全局配置
        GlobalConfig gc = new GlobalConfig();
//获取当前项目路径
        String projectPath = System.getProperty("user.dir");
// 生成目录
        gc.setOutputDir("E:\\学习\\code\\advertising_system\\alone-ad-service\\ad-sponsor"+"/src/main/java");
        gc.setBaseResultMap(true) ;//XML中的ResultMap标签
        gc.setBaseColumnList(true); //XML标签
// 设置作者
        gc.setAuthor("Alone");
// 是否打开资源管理器
        gc.setOpen(false);
// 是否覆盖
        gc.setFileOverride(true);
// 主键生成策略
        gc.setIdType(IdType.ASSIGN_ID);
// 设置日期类型
        gc.setDateType(DateType.TIME_PACK);
// 保存全局配置
        mpg.setGlobalConfig(gc);

// 2、设置数据源
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://121.40.177.19:3306/alone_ad_data?&useSSL=false&serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=UTF-8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);
// 保存数据源配置
        mpg.setDataSource(dsc);

// 3、包的配置
        PackageConfig pc = new PackageConfig();
// 模块名
        pc.setModuleName("ad");
// 放在哪个包下
        pc.setParent("com.alone");
// 实体类包名
        pc.setEntity("entity");
// 持久层包名
        pc.setMapper("mapper");
// 业务层包名
        pc.setService("service");
// 表现层包名
        pc.setController("controller");
// 保存包的配置
        mpg.setPackageInfo(pc);

//4、策略配置
        StrategyConfig strategy = new StrategyConfig();
// 要映射的表名
//        strategy.setInclude("user","rule","role","role_rule_relation","position","branch","leave","attendance","branch_relation");
// 表名下划线转驼峰
        strategy.setNaming(NamingStrategy.underline_to_camel);
// 列名下划线转驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
// 自动lombok
        strategy.setEntityLombokModel(true);
        ArrayList<TableFill> tableFills = new ArrayList<>();
// 自动填充 gmt_create
        TableFill gmtCreate = new TableFill("create_time", FieldFill.INSERT);
// 自动填充 gmt_modified
        TableFill gmtModified = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        tableFills.add(gmtCreate);
        tableFills.add(gmtModified);
// 设置自动填充字段
        strategy.setTableFillList(tableFills);
// 生成 @RestController 控制器
        strategy.setRestControllerStyle(true);
// controller路径里驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);
        mpg.execute(); //执行
    }
}
