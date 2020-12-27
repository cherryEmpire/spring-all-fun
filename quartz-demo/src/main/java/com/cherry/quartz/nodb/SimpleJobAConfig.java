package com.cherry.quartz.nodb;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Cherry
 * @Date: 2020/12/22
 * @Desc: SimpleJobAConfig
 */
@Configuration
public class SimpleJobAConfig {

    @Bean
    public JobDetail sampleJobDetail() {
        // 链式编程,可以携带多个参数,在Job类中声明属性 + setter方法
        return JobBuilder.newJob(SimpleJobA.class).withIdentity("simpleJobA")
                .usingJobData("name","World").storeDurably().build();
    }

    @Bean
    public Trigger sampleJobTrigger(){
        // 每隔两秒执行一次
        SimpleScheduleBuilder scheduleBuilder =
                SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever();
        return TriggerBuilder.newTrigger().forJob(sampleJobDetail()).withIdentity("simpleJobATrigger")
                .withSchedule(scheduleBuilder).build();
    }
}
