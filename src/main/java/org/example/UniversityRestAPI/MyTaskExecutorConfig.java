package org.example.UniversityRestAPI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class MyTaskExecutorConfig {

    // Would Spring shut it down for us?
    @Bean(name = "threadPoolTaskExecutor")
    public TaskExecutor threadPoolTaskExecutor() {

        ThreadPoolTaskExecutor threadPoolTaskExecutor =
                new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(20);
        //...
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;
    }

    @Bean(name = "threadPoolTaskExecutor2")
    public TaskExecutor threadPoolTaskExecutor2() {

        ThreadPoolTaskExecutor threadPoolTaskExecutor =
                new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(5);
        threadPoolTaskExecutor.setMaxPoolSize(10);
        threadPoolTaskExecutor.setQueueCapacity(20);
        //...
        threadPoolTaskExecutor.initialize();

        return threadPoolTaskExecutor;
    }

}
