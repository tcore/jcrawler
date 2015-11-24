package jcrawler.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "attribute_set")
@Getter
@Setter
public class AttributeSet {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(targetEntity = AttributeValue.class, mappedBy = "set")
    private Set<AttributeValue> attributes = new HashSet<>();
}
