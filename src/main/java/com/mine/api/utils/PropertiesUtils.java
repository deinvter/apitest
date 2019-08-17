package com.mine.api.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *	Properties配置文件处理工具
 * @author wdy
 */
public class PropertiesUtils {
    // 静态块中不能有非静态属性，所以加static
    private static Properties prop = null;
    private static String propertity="application.properties";
    //静态块中的内容会在类别加载的时候先被执行
    static {
        try {
            prop = new Properties();
            // prop.load(new FileInputStream(new File("C:\\jdbc.properties")));
            prop.load(PropertiesUtils.class.getClassLoader().getResourceAsStream(propertity));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //静态方法可以被类名直接调用
    public static String getValue(String key) {
        return prop.getProperty(key);
    }
}