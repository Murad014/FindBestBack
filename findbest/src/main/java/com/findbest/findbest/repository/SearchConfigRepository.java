package com.findbest.findbest.repository;

import com.findbest.findbest.entity.SearchConfig;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SearchConfigRepository extends JpaRepository<SearchConfig, Long> {
    SearchConfig findByIsActive(Byte isActive);

}
