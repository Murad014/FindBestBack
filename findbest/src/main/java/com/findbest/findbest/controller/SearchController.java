package com.findbest.findbest.controller;

import com.findbest.findbest.models.ProductsSearchResultModel;
import com.findbest.findbest.models.SearchRequestModel;
import com.findbest.findbest.services.ProductSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;

@RestController
@RequestMapping("/api/v1/search")
public class SearchController {

    private final ProductSearchService productSearchService;

    @Autowired
    public SearchController(ProductSearchService productSearchService){
        this.productSearchService = productSearchService;
    }


    @GetMapping
    public ResponseEntity<ProductsSearchResultModel> search(@RequestParam("key") String searchKey) throws MalformedURLException {
        SearchRequestModel request = new SearchRequestModel(searchKey);

        return new ResponseEntity<>(productSearchService.getProducts(request),
                HttpStatus.OK);
    }


}
