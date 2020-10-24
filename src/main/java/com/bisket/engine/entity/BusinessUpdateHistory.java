package com.bisket.engine.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BusinessUpdateHistory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String businessCategoryName;
    private String businessCategoryTableName;
    @Column(nullable = false)
    private LocalDateTime executeDate = LocalDateTime.now();
    @Column(nullable = false)
    private boolean successFlag = false;
    private Integer dataCount;
}
