package cn.fxbworld.util;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import cn.fxbworld.config.LoggingAspect;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Auther ShuPF
 * @Create 2017/7/5 0005
 */
@Slf4j
public class MybatisPlusUtils{
	private static Logger log = LoggerFactory.getLogger(LoggingAspect.class);
    public static void main(String[] args) {
        String[] models = {"ssm-mapper","ssm-model","ssm-service","ssm-web"};
        for (String model : models) {
            shell(model,"user");
        }
    }

    private static void shell(String model, String tabName){
        File file = new File(model);
        String path = file.getAbsolutePath();
        //path = path.substring(0, path.lastIndexOf(File.separator));
        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(path+"/src/main/java");
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("ShuPF");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("I%sMapper");
        gc.setXmlName("I%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("I%sServiceImpl");
        gc.setControllerName("I%sController");
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public DbColumnType processTypeConvert(String fieldType) {
                System.out.println("转换类型：" + fieldType);
                // 注意！！processTypeConvert 存在默认类型转换，如果不是你要的效果请自定义返回、非如下直接返回。
                return super.processTypeConvert(fieldType);
            }
        });


        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("ds940805.");
        dsc.setUrl("jdbc:mysql:///test?characterEncoding=utf8");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        // strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        strategy.setTablePrefix(new String[] { "tlog_", "tsys_" });// 此处可以修改为您的表前缀
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(new String[] {tabName}); // 需要生成的表
        // strategy.setExclude(new String[]{"test"}); // 排除生成的表
        // 自定义实体父类
        //strategy.setSuperEntityClass("com.ds.model.Entity");
        // 自定义实体，公共字段
        //strategy.setSuperEntityColumns(new String[] { "test_id", "age" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        //strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        //strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        //strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        // strategy.setEntityColumnConstant(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuliderModel(true);
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.ds");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");
        pc.setServiceImpl("impl");
        //pc.setModuleName("test");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };

        // 自定义 xxList.jsp 生成
        List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
//    focList.add(new FileOutConfig("/template/list.jsp.vm") {
//       @Override
//       public String outputFile(TableInfo tableInfo) {
//          // 自定义输入文件名称
//          return "D://my_" + tableInfo.getEntityName() + ".jsp";
//       }
//    });
//    cfg.setFileOutConfigList(focList);
//    mpg.setCfg(cfg);

        // 调整 xml 生成目录演示
        focList.add(new FileOutConfig("/templates/mapper.xml.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        //多模块
        TemplateConfig tc = getTemplateConfig(gc,pc,model,tabName, false);
        if (tc.getMapper() == null && tc.getXml() == null && tc.getService() == null &&
                tc.getServiceImpl() == null && tc.getController() == null && tc.getEntity() == null) {
            return;
        }
        // 关闭默认 xml 生成，调整生成 至 根目录（单模块）
//        TemplateConfig tc = new TemplateConfig();
//    tc.setController("java.com.SpringBoot.ibats.controller");
//    tc.setEntity("java.com.SpringBoot.ibats.model.Entity");
//     tc.setMapper("java.com.SpringBoot.ibats.mapper");
//     tc.setXml("src.resources.sqlBaties");
//     tc.setService("java.com.SpringBoot.ibats.service");
//     tc.setServiceImpl("java.com.SpringBoot.ibats.service.impl");
        mpg.setTemplate(tc);

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
        // 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        // TemplateConfig tc = new TemplateConfig();
        // tc.setController("...");
        // tc.setEntity("...");
        // tc.setMapper("...");
        // tc.setXml("...");
        // tc.setService("...");
        // tc.setServiceImpl("...");
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
        // 打印注入设置【可无】
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

    /**
     * 控制包生成的路径与是否覆盖生成
     * @param gc // 全局配置
     * @param pc 包配置
     * @param model model名
     * @param tabName 表名
     * @param isCover 是否覆盖生成代码
     * @return TemplateConfig
     */
    private static TemplateConfig getTemplateConfig(GlobalConfig gc,  PackageConfig pc, String model, String tabName, boolean isCover) {
        TemplateConfig tc = new TemplateConfig();
        String entity = BaseUtils.getName(tabName,"_");
        String path = model + "/src/main/java/" +replace( pc.getParent());
        if (!isCover) {
            if ("ssm-mapper".equals(model)) {
                String mapperPath =path + "/" + replace(pc.getMapper()) + "/" + gc.getMapperName().replace("%s",entity) + ".java";
                if (isExists(mapperPath)) {
                    tc.setMapper(null);
                    log.info(gc.getMapperName().replace("%s",entity) + ".java 文件已存在");
                }
                String mapperXmlPath =path + "/" + replace(pc.getXml()) + "/" + gc.getXmlName().replace("%s",entity) + ".xml";
                if (isExists(mapperXmlPath)) {
                    tc.setXml(null);
                    log.info(gc.getXmlName().replace("%s",entity) + ".xml 文件已存在");
                }
                tc.setController(null);
                tc.setEntity(null);
                tc.setService(null);
                tc.setServiceImpl(null);
            } else if ("ssm-model".equals(model)) {
                String modelPath = path + "/" + replace(pc.getEntity()) + "/" + entity + ".java";
                if (isExists(modelPath)) {
                    tc.setEntity(null);
                    log.info(entity + ".java 文件已存在");
                }
                tc.setController(null);
                tc.setService(null);
                tc.setServiceImpl(null);
                tc.setMapper(null);
                tc.setXml(null);
            }  else if ("ssm-service".equals(model)) {
                String servicePath = path + "/" +replace(pc.getService()) + "/" +  gc.getServiceName().replace("%s",entity) + ".java";
                if (isExists(servicePath)) {
                    tc.setService(null);
                    log.info(gc.getServiceName().replace("%s",entity) + ".java 文件已存在");
                }
                String serviceImplPath = path + "/" +replace(pc.getServiceImpl()) + "/" +  gc.getServiceImplName().replace("%s",entity) + ".java";
                if (isExists(serviceImplPath)) {
                    tc.setServiceImpl(null);
                    log.info(gc.getServiceImplName().replace("%s",entity) + ".java 文件已存在");
                }
                tc.setController(null);
                tc.setMapper(null);
                tc.setXml(null);
                tc.setEntity(null);
            } else if ("ssm-web".equals(model)) {
                String controllerPath = path + "/" +replace(pc.getController()) + "/" + gc.getControllerName().replace("%s",entity) + ".java";;
                if (isExists(controllerPath)) {
                    tc.setController(null);
                    log.info(gc.getControllerName().replace("%s",entity) + ".java 文件已存在");
                }
                tc.setMapper(null);
                tc.setXml(null);
                tc.setService(null);
                tc.setServiceImpl(null);
                tc.setEntity(null);
            }
        } else {
            if ("ssm-mapper".equals(model)) {
                tc.setController(null);
                tc.setEntity(null);
                tc.setService(null);
                tc.setServiceImpl(null);
            } else if ("ssm-model".equals(model)) {
                tc.setController(null);
                tc.setService(null);
                tc.setServiceImpl(null);
                tc.setMapper(null);
                tc.setXml(null);
            }  else if ("ssm-service".equals(model)) {
                tc.setController(null);
                tc.setMapper(null);
                tc.setXml(null);
                tc.setEntity(null);
            } else if ("ssm-web".equals(model)) {
                tc.setMapper(null);
                tc.setXml(null);
                tc.setService(null);
                tc.setServiceImpl(null);
                tc.setEntity(null);
            }
        }
        return tc;
    }

    /**
     * 判断文件是否存在
     * @param path 路径
     * @return
     */
    private static boolean isExists(String path) {
        File file = new File(path);
        return file.exists();
    }

    /**
     * 将点替换为斜杠
     * @param name
     * @return
     */
    private static String replace(String name) {
        return name.replace(".","/");
    }

}
