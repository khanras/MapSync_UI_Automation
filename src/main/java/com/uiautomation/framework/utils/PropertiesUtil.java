package com.uiautomation.framework.utils;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
    private static PropertiesUtil propertiesUtilInstance = null;
    private Properties propApp = new Properties();
    private PropertiesUtil() {
        this.setProperties();
    }

    private void setProperties(){
        try {
            ClassLoader classLoader = PropertiesUtil.class.getClassLoader();
            InputStream in = classLoader.getResourceAsStream("application.properties");
            propApp.load(in);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized PropertiesUtil getPropertiesUtil(){
        if (propertiesUtilInstance==null){
            synchronized (PropertiesUtil.class){
                if (propertiesUtilInstance==null) {
                    propertiesUtilInstance = new PropertiesUtil();
                }
            }
        }
        return propertiesUtilInstance;
    }
    public String getApplication(String key){
        return propApp.getProperty(key);
    }
}
