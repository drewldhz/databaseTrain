package com.petagent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pet")
public class Pet {

    private int _id;
    private String _name;

    public Pet() {

    }

    public Pet(int id, String name) {
        this._id = id;
        this._name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    @Column(name = "name", nullable = false)
    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    @Override
    public String toString() {
        return "Pet [id=" + _id + ", name=" + _name + "]";
    }
}
