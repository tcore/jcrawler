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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}
