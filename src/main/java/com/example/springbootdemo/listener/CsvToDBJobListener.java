package com.example.springbootdemo.listener;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

//作业状态--接口方式
public class CsvToDBJobListener implements JobExecutionListener {

    //作业执行前
    @Override
    public void beforeJob(JobExecution jobExecution) {
        long begin = System.currentTimeMillis();
        jobExecution.getExecutionContext().putLong("begin", begin);
        System.err.println("-------------------------【CsvToDBJob开始时间：】---->" + begin + "<-----------------------------");
    }

    //作业执行后
    @Override
    public void afterJob(JobExecution jobExecution) {
        long begin = jobExecution.getExecutionContext().getLong("begin");
        long end = System.currentTimeMillis();
        System.err.println("-------------------------【CsvToDBJob结束时间：】---->" + end + "<-----------------------------");
        System.err.println("-------------------------【CsvToDBJob总耗时：】---->" + (end - begin) + "<-----------------------------");
    }
}