package com.nvc.assignment.data.client;

import lombok.Data;

@Data
public class SearchWordRequest {
    private String text;
    private String word;
}
