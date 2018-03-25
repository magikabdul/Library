package com.kodilla.cholewa.library.domain.copies;

import com.kodilla.cholewa.library.domain.titles.TitleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CopyDto {
    private Long id;

    private TitleDto titleDto;

    private String status;
}
