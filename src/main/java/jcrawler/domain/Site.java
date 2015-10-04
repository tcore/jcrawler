package jcrawler.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "site")
public class Site {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "host", nullable = false)
    private String host;

    @OneToMany(targetEntity = Page.class, mappedBy = "site")
    private Set<Page> pages = new HashSet<>();

    public String toString() {
        return "http://" + host;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public Set<Page> getPages() {
        return pages;
    }

    public void setPages(Set<Page> pages) {
        this.pages = pages;
    }
}
