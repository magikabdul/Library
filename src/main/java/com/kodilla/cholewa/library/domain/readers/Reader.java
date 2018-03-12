package com.kodilla.cholewa.library.domain.readers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "READERS")
@SequenceGenerator(name = "READER_GEN", sequenceName = "READER_SEQ")
public class Reader {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "READER_GEN")
    @NotNull
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "FIRSTNAME")
    private String firstName;

    @Column(name = "LASTNAME")
    private String lastName;

    @Column(name = "CREATED")
    private Date created;

    public Reader(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        created = new Date();
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private void setCreated(Date created) {
        this.created = created;
    }
}
