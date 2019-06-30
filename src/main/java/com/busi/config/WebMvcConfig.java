package com.busi.config;

import com.souche.tangeche.comment.CommentResolver;
import com.souche.tangeche.comment.Resolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by hehe on 2017/7/25.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Bean(initMethod = "init")
    public Resolver commentResolver() {
        String scanCommentPath = "com.busi.domain";
        CommentResolver resolver = new CommentResolver();
        resolver.setScanPackagePath(scanCommentPath);
        return resolver;
    }
}
