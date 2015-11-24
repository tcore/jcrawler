package jcrawler.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "page")
@Getter
@Setter
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
}
