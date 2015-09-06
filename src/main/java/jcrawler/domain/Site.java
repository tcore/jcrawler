package jcrawler.domain;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "site")
public class Site {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "host", nullable = false)
    private String host;

    @OneToMany(targetEntity = Page.class)
    private Set<Page> pages;
}
