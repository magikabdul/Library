package com.kodilla.cholewa.library.mapper;

import com.kodilla.cholewa.library.domain.copies.Copy;
import com.kodilla.cholewa.library.domain.copies.CopyDto;
import com.kodilla.cholewa.library.domain.titles.Title;
import org.springframework.stereotype.Component;

@Component
public class CopyMapper {

    public Copy mapToCopy(Title title) {
        return new Copy(title, Copy.STATUS_AVAILABLE);
    }

    public Copy mapToCopy(CopyDto copyDto) {


        return new Copy(copyDto.getTitle(),
                copyDto.getStatus());
    }
}
