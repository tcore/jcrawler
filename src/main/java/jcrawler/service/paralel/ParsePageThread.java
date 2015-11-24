package jcrawler.service.paralel;

import jcrawler.domain.Page;
import jcrawler.repository.PageRepository;
import jcrawler.service.Processor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class ParsePageThread extends Thread {
    @Autowired
    private Processor processor;

    @Setter
    private Page page;

    public void run() {
        System.out.println(page + " ==> " + processor.process(page));
    }
}
