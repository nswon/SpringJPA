package com.example.naveropenapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Req<T> {

    private Header header;
    private T body;

    public static class Header {
        private String responseCode;
    }
}
