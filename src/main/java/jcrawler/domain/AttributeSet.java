package jcrawler.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "attribute_set")
public class AttributeSet {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(targetEntity = AttributeValue.class, mappedBy = "set")
    private Set<AttributeValue> attributes = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<AttributeValue> getAttributes() {
        return attributes;
    }

    public void setAttributes(Set<AttributeValue> attributes) {
        this.attributes = attributes;
    }
}
