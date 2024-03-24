package com.findbest.findbest.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "searchConfig")
public class SearchConfig {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="configName", nullable = false, unique = true)
    private String configName;

    @Column(name="subscriptionKey", nullable = false, unique = true)
    private String subscriptionKey;

    @Column(name="host", nullable = false)
    private String host;

    @Column(name="path", nullable = false)
    private String path;

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Set<SearchConfigParams> searchConfigParamsList;

    @Column(name = "createdDate", updatable = false)
    @CreationTimestamp
    private Timestamp createdDate;

    @Column(name = "updatedDate")
    @UpdateTimestamp
    private Timestamp updatedDate;

    @Column(name="isActive")
    @Builder.Default
    private Byte isActive = 0;




}
