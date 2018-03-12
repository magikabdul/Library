package com.kodilla.cholewa.library.domain.copies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "COPIES")
@SequenceGenerator(name = "COPIES_GEN", sequenceName = "COPIES_SEQ")
public class Copy {
    public static final String STATUS_IN_USE = "in use";
    public static final String STATUS_DAMAGED = "damaged";
    public static final String STATUS_LOST = "lost";

    @Id
    @NotNull
    @GeneratedValue(generator = "COPIES_GEN")
    @Column(name = "ID", unique = true)
    private Long id;

    @Column(name = "TITLE_ID")
    private Long titleId;

    @Column(name = "STATUS")
    private String status;

    public Copy(Long titleId, String status) {
        this.titleId = titleId;
        this.status = status;
    }

    private void setId(Long id) {
        this.id = id;
    }

    private void setTitleId(Long titleId) {
        this.titleId = titleId;
    }

    private void setStatus() {
        this.status = status;
    }
}
