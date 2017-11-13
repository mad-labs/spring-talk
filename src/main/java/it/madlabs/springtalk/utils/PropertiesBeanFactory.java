package it.madlabs.springtalk.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class PropertiesBeanFactory implements BeanFactory {

    private final Map<String, Object> applicationContext = new ConcurrentHashMap<String, Object>();

    public PropertiesBeanFactory(String file) {
        Properties properties = loadProperties(file);

        String startWith = "bean.";
        for (String rawBeanName : properties.stringPropertyNames()) {
            if (rawBeanName.startsWith("bean.")){
                try {
                    String beanName = rawBeanName.replace("bean.", "");
                    String beanClassName = properties.getProperty(rawBeanName);
                    Class<?> beanClass = Class.forName(beanClassName);
                    Object bean = beanClass.newInstance();
                    applicationContext.put(beanName, bean);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
        for (String rawRefConfig : properties.stringPropertyNames()) {
            if (rawRefConfig.startsWith("ref.")){
                try {
                    String refConfig = rawRefConfig.replace("ref.", "");

                    String beanClassName = properties.getProperty(rawRefConfig);
                    Class<?> beanClass = Class.forName(beanClassName);
                    Object bean = beanClass.newInstance();
                    applicationContext.put(refConfig, bean);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    private Properties loadProperties(String file) {
        Properties properties = new Properties();
        try {
            InputStream input = new FileInputStream(file);
            properties.load(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public Object getBean(String beanName) {
        return null;
    }
}
