package com.nvc.assignment.controller;

import com.nvc.assignment.data.client.SearchWordRequest;
import com.nvc.assignment.data.client.SearchWordResponse;
import com.nvc.assignment.domain.service.SearchWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchWordController {

    @Autowired
    private SearchWordService service;

    @PostMapping("/search-word")
    public ResponseEntity<SearchWordResponse> searchWord(@RequestBody SearchWordRequest request){
        return ResponseEntity.ok(service.searchWord(request));
    }
}
