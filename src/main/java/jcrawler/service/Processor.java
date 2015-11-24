package jcrawler.service;

import jcrawler.domain.Page;
import jcrawler.domain.Site;
import jcrawler.repository.PageRepository;
import jcrawler.repository.SiteRepository;
import jcrawler.service.parser.domain.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Set;

@Service
public class Processor {
    @Autowired
    Crawler crawler;

    @Autowired
    PageRepository pageRepository;

    @Autowired
    SiteRepository siteRepository;

    public int process(Page page) {
        int countNew = 0;

        try {
            Set<Link> links = crawler.getLinks(page);
            for (Link l : links) {
                String foundHost = l.getUri().getHost();
                String foundPath = l.getUri().getPath();
                if (foundPath.equals("")) {
                    foundPath = null;
                }
                Site site = siteRepository.findByHost(foundHost);
                Page foundPage = null;
                if (site == null) {
                    site = new Site();
                    site.setHost(foundHost);
                } else {
                    foundPage = pageRepository.findBySiteAndPath(site, foundPath);
                }
                if (foundPage == null) {
                    foundPage = new Page();
                    foundPage.setDateCreated(new Date());
                    foundPage.setPath(foundPath);
                    foundPage.setSite(site);
                    siteRepository.save(site);
                    pageRepository.save(foundPage);
                    countNew++;
                }
            }
        } catch (Exception e) {
            System.err.print(e.getMessage());
        }

        page.setDateLastParsed(new Date());
        pageRepository.save(page);

        return countNew;
    }
}
