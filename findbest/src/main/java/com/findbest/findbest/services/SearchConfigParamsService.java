package com.findbest.findbest.services;

import com.findbest.findbest.entity.SearchConfigParams;
import com.findbest.findbest.repository.SearchConfigParamsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchConfigParamsService {

    private final SearchConfigParamsRepository searchConfigParamsRepository;

    @Autowired
    public SearchConfigParamsService(SearchConfigParamsRepository searchConfigParamsRepository){
        this.searchConfigParamsRepository = searchConfigParamsRepository;
    }

    public SearchConfigParams add(SearchConfigParams searchConfigParams){
        return searchConfigParamsRepository.save(searchConfigParams);
    }


}
