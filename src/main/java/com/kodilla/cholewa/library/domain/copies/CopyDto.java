package com.kodilla.cholewa.library.domain.copies;

import com.kodilla.cholewa.library.domain.titles.Title;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CopyDto {
    private Long id;
    private Title title;
    private String status;
}
