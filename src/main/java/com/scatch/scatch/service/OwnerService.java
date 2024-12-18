package com.scatch.scatch.service;

import com.scatch.scatch.model.OwnerModel;
import com.scatch.scatch.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepo;

    public int findNoOfOwner() {
        List<OwnerModel> ownerList =  ownerRepo.findAll();
        if(!ownerList.isEmpty()){
            System.out.println("Owner already Exists");
            return 1;
        }
        else {
            System.out.println("Owner dose not exist");
            return 0;
        }
    }

    public OwnerModel createOwner(OwnerModel owner) {
        return ownerRepo.save(owner);
    }

    public List<OwnerModel> getOwner() {
        return ownerRepo.findAll();
    }

    public OwnerModel findOwner() {
        List<OwnerModel> ownerList = ownerRepo.findAll();
        if(!ownerList.isEmpty()){
            return ownerList.get(0);
        }
        else throw new RuntimeException("No owner Found");
    }
}
