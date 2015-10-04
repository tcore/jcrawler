package jcrawler;

import jcrawler.domain.Page;
import jcrawler.repository.PageRepository;
import jcrawler.service.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JCrawlerApplication implements CommandLineRunner {
    @Autowired
    Processor processor;

    @Autowired
    PageRepository pageRepository;

    public static void main(String[] args) {
        SpringApplication.run(JCrawlerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        while (true) {
            Page page = pageRepository.findOneByDateLastParsedIsNull().get(0);
            System.out.println(page + " ==> " + processor.process(page));
        }
    }
}
