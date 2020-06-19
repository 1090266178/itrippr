package com.testtt;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class RemindJob implements Job {
    /**
     * Job接口只有一个execute方法，在实现类中实现该方法以执行具体任务
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //提醒服务类 封装提醒业务
        System.out.println("执行一次");
    }
}
