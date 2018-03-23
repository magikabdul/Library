package com.kodilla.cholewa.library.domain.copies;

import com.kodilla.cholewa.library.domain.rents.Rent;
import com.kodilla.cholewa.library.domain.titles.Title;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity(name = "COPIES")
@SequenceGenerator(name = "COPIES_GEN", sequenceName = "COPIES_SEQ")
public class Copy {
    public static final String STATUS_AVAILABLE = "available";
    public static final String STATUS_IN_USE = "in use";
    public static final String STATUS_DAMAGED = "damaged";
    public static final String STATUS_LOST = "lost";

    @Id
    @NotNull
    @GeneratedValue(generator = "COPIES_GEN")
    @Column(name = "ID", unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TITLE_ID")
    private Title title;

    @Column(name = "STATUS")
    private String status;

    @OneToMany(
            targetEntity = Rent.class,
            mappedBy = "copy",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Rent> rentList;

    public Copy(Title title, String status) {
        this.title = title;
        this.status = status;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setRentList(List<Rent> rentList) {
        this.rentList = rentList;
    }
}
