package com.rishi;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class BeanLifeCycle implements InitializingBean, DisposableBean {

    private static final Logger log = LoggerFactory.getLogger(BeanLifeCycle.class);

    public BeanLifeCycle() {
        log.info("1. Bean Created ");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("3. Initialization InitializingBean.afterPropertiesSet() called");
    }


    @PostConstruct
    public void postConstructInit() {
        log.info("2. Initialization  @PostConstruct called");
    }


    @PreDestroy
    public void preDestroyCleanup() {
        log.info("4. Destruction  @PreDestroy called");
    }

    @Override
    public void destroy() throws Exception {
        log.info("5. Destruction - DisposableBean.destroy() called");
    }
}