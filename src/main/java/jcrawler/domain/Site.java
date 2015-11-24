package jcrawler.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "site")
@Getter
@Setter
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
}
