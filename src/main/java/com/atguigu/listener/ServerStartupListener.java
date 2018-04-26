package com.atguigu.listener;

import org.apache.log4j.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by luwan on 2018/3/23.
 */
public class ServerStartupListener implements ServletContextListener {

    private static final Logger logger = Logger.getLogger(ServerStartupListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // 获取web应用对象
        ServletContext application = sce.getServletContext();

        // 获取web应用路径
        String path = application.getContextPath();
        logger.info(application+"**********************");
        logger.info(path+"**********************");
        // 将路径保存在application范围中
        application.setAttribute("APP_PATH", path);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
