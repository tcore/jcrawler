package jcrawler.domain;

import javax.persistence.*;

@Entity(name = "page")
public class Page {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "path")
    private String path;

    @ManyToOne(targetEntity = Site.class)
    @JoinColumn(name = "site_id", nullable = false)
    private Site site;
}
