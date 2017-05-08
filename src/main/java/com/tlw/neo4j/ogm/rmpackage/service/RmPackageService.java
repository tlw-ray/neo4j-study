package com.tlw.neo4j.ogm.rmpackage.service;

import com.tlw.neo4j.ogm.rmpackage.domain.RmPackage;
import com.tlw.neo4j.ogm.rmpackage.repository.RmPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 唐力伟 on 2017/5/4 20:11.
 */
@Service
public class RmPackageService {

    @Autowired
    RmPackageRepository repository;

    @Transactional
    public void createRmPackages(){
        RmPackage com = new RmPackage();
        com.setName("com");

        RmPackage tlw = new RmPackage();
        tlw.setName("tlw");

        RmPackage p1 = new RmPackage();
        p1.setName("p1");

        RmPackage p2 = new RmPackage();
        p2.setName("p2");

        com.add(tlw);
        tlw.add(p1);
        tlw.add(p2);

        repository.save(com);

    }

}
