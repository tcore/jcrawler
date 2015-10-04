package jcrawler.repository;

import jcrawler.domain.Page;
import jcrawler.domain.Site;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PageRepository extends JpaRepository<Page, Long> {
    List<Page> findOneByDateLastParsedIsNull();

    Page findBySiteAndPath(Site site, String path);
}
