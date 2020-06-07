package com.techcelestial.dheerajacademy;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.text.ParseException;
import java.util.Date;
import java.util.TimeZone;

@SpringBootApplication(scanBasePackages = "com.techcelestial.dheerajacademy")
public class Application {


    @PostConstruct
    void started() throws ParseException {

        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Kolkata"));
        Date today1 = new Date();

        System.out.println("todayDate"+today1);


    }


    public static void main(String args[])
    {
        SpringApplication.run(Application.class,args);
    }

}

