package com.kodilla.cholewa.library.domain.titles;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TitleDto {
    private Long id;
    private String title;
    private String author;
    private int publicationYear;
}
