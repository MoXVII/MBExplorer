package uk.ac.le.cs.CO3098.cw3;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MBExplorerApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(MBExplorerApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

}
