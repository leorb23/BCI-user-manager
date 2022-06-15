package com.nvc.assignment.domain.service;

import com.nvc.assignment.data.client.SearchWordRequest;
import com.nvc.assignment.data.client.SearchWordResponse;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Arrays;

@Service
public class SearchWordService {

    public SearchWordResponse searchWord(SearchWordRequest request){

        String[] words = request
                .getText()
                .trim()
                .replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()”“\"…]"," ")
                .split(" ");

        String wordSearch = request.getWord().trim().toLowerCase();

        ArrayList<String> permutations = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String wordCompare = words[i];

            if(wordCompare.length() == wordSearch.length()) {
                char[] lettersCompareSort = wordCompare.toLowerCase().toCharArray();
                char[] lettersSearchSort = wordSearch.toCharArray();
                Arrays.sort(lettersCompareSort);
                Arrays.sort(lettersSearchSort);
                if(String.valueOf(lettersCompareSort).equals(String.valueOf(lettersSearchSort))){
                    permutations.add(wordCompare);
                }
            }

        }

        SearchWordResponse response = new SearchWordResponse();
        response.setAmountOfPermutation(permutations.size());
        String[] list = new String[permutations.size()];
        response.setPermutations(permutations.toArray(list));

        return response;
    }
}
