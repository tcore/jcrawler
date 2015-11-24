package jcrawler.service.paralel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class ParalelConfiguration {
    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(50);
        pool.setMaxPoolSize(100);
        pool.setWaitForTasksToCompleteOnShutdown(true);

        return pool;
    }
}
