package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void lifeCycleTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient3 client3 = ac.getBean(NetworkClient3.class);
        ac.close(); // 스프링 컨테이너를 종료, ConfigurableApplicationContext 필요

    }

    @Configuration
    static class LifeCycleConfig {

        @Bean(initMethod = "init", destroyMethod = "close")
        public NetworkClient3 networkClient3() {
            NetworkClient3 networkClient3 = new NetworkClient3();
            networkClient3.setUrl("http://hello-spring.dev");
            return networkClient3;
        }
    }
}

