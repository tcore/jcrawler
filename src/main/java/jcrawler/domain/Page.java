package jcrawler.domain;

import javax.persistence.*;
import java.util.Date;

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

    @Column(name = "date_last_parsed", nullable = true)
    private Date dateLastParsed;

    @Column(name = "date_created", nullable = false)
    private Date dateCreated;

    public String toString() {
        if (path != null) {
            return site.toString() + path;
        }

        return site.toString();
    }

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

    public Date getDateLastParsed() {
        return dateLastParsed;
    }

    public void setDateLastParsed(Date dateLastParsed) {
        this.dateLastParsed = dateLastParsed;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
