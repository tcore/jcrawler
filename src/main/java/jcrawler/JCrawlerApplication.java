package jcrawler;

import jcrawler.domain.Page;
import jcrawler.repository.PageRepository;
import jcrawler.service.paralel.ParsePageThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.List;

@SpringBootApplication
public class JCrawlerApplication implements CommandLineRunner {
    @Autowired
    private ApplicationContext context;

    @Autowired
    private PageRepository pageRepository;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    public static void main(String[] args) {
        SpringApplication.run(JCrawlerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {

        do {
            List<Page> list = pageRepository.findOneByDateLastParsedIsNull(new PageRequest(0, 10));
            list.forEach(this::executeParsePageThread);

            for (;;) {
                int count = taskExecutor.getActiveCount();
                System.out.println("Active Threads : " + count);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (count == 0) {
                    break;
                }
            }
        } while (true);
    }

    private void executeParsePageThread(Page page) {
        ParsePageThread parsePageThread = (ParsePageThread) context.getBean("parsePageThread");
        parsePageThread.setPage(page);
        taskExecutor.execute(parsePageThread);
    }
}
