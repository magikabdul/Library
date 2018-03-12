package com.kodilla.cholewa.library.domain.copies;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CopyDto {
    private Long id;
    private Long titleId;
    private String status;
}
