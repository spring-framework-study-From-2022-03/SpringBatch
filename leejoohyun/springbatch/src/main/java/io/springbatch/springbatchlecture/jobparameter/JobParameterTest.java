package io.springbatch.springbatchlecture.jobparameter;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

//@Component
public class JobParameterTest implements ApplicationRunner {

    @Autowired private JobLauncher jobLauncher;

    @Autowired
    Job job;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /**
         * java -jar springbatchlecture-0.0.1-SNAPSHOT.jar name=user1 seq"(long)"=2L date"(date)"=2021/01/01 age"(double)"=16.2
         */
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("name", "user1")
                .addLong("seq", 2L)
                .addDate("date", new Date())
                .addDouble("age", 16.5)
                .toJobParameters();

        jobLauncher.run(job, jobParameters);
    }
}
