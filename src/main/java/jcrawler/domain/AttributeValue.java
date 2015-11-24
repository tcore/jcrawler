package jcrawler.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "attribute_value")
@Getter
@Setter
public class AttributeValue {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "value", nullable = false)
    private String value;

    @ManyToOne(targetEntity = AttributeSet.class)
    @JoinColumn(name = "set_id")
    private AttributeSet set;
}
