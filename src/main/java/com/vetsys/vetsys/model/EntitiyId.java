package com.vetsys.vetsys.model;

import javax.persistence.*;

@MappedSuperclass
public class EntitiyId {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

  public EntitiyId() {
  }

  public EntitiyId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
