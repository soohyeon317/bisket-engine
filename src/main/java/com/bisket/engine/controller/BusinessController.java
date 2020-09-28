package com.bisket.engine.controller;

import com.bisket.engine.service.BusinessService;
import com.bisket.engine.constant.FileExtension;
import com.bisket.engine.domain.Business;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/businesses")
@Slf4j
public class BusinessController {
    private final BusinessService businessService;

    public BusinessController(BusinessService businessService) {
        this.businessService = businessService;
    }

    @PutMapping
    public Integer updateList(
            @RequestParam("file_extension") FileExtension fileExtension,
            @RequestParam(value = "target_xml_file_name", required = false) String targetXmlFileName
    ) {
        return businessService.updateList(fileExtension, targetXmlFileName);
    }

    @GetMapping
    public List<Business> getList() {
        return businessService.getList();
    }

    @GetMapping("/{id}")
    public Business getOneById(@PathVariable Long id) {
        return businessService.getOneById(id);
    }
}
