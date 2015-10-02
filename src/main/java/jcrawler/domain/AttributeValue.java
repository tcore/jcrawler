package jcrawler.domain;

import javax.persistence.*;

@Entity(name = "attribute_value")
public class AttributeValue {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "value", nullable = false)
    private String value;

    @ManyToOne(targetEntity = AttributeSet.class)
    @JoinColumn(name = "set_id")
    private AttributeSet set;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AttributeSet getSet() {
        return set;
    }

    public void setSet(AttributeSet set) {
        this.set = set;
    }
}
