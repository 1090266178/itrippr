package com.testtt;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.util.Date;

public class testMain {
    public static void main(String[] args) throws SchedulerException, ParseException {
        //创建job 任务
        JobDetail jon = new JobDetail("myJob","job",RemindJob.class); //第一个参数表示这个任务的名称第二个参数表示分组第三个通过反射得到RemindJob类中的重写方法

        //创建触发器 trigger
        SimpleTrigger trigger = new SimpleTrigger("mytrigger",SimpleTrigger.REPEAT_INDEFINITELY,3000); //第一个参数表示触发器的名称第二个值是-1表示循环第三个参数以毫秒为单位表示3秒
        trigger.setStartTime(new Date(System.currentTimeMillis()+1000));//表示设置开始时间是当前时间加1秒后

        //第二种触发器 比较常用
        //秒 分 时 日 月 周 年 表达式必须指定6-7个字段
        //?用于月份中的哪一天和星期几的字段，表示不指定值，硬性规则是哪一天和星期几必须有一个写？并且不能两个都写问号 年可以不写默认是每一年
        CronTrigger cronTrigger = new CronTrigger("myCoronTrigger","b","* * * ? * *");

        //创建调度器
        //创建Scheduler工厂的SchedulerFactory实例
        SchedulerFactory factory = new StdSchedulerFactory();
        //获取调度器
        Scheduler scheduler = factory.getScheduler();
        //粘合任务和触发器
        scheduler.scheduleJob(jon,cronTrigger);
        scheduler.start();
    }
}
