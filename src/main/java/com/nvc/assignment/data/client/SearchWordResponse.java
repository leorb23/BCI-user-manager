package com.nvc.assignment.data.client;

import lombok.Data;

@Data
public class SearchWordResponse {
    private int amountOfPermutation;
    private String[] permutations;

}
