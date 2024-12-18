package com.scatch.scatch.controller;

import com.scatch.scatch.model.OwnerModel;
import com.scatch.scatch.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;


//    @GetMapping("/admin")
//    public String ownerCreateProduct(Model model) {
//        return "createproducts";
//    }



}














//    @PostMapping("/createOwner")
//    public OwnerModel createOwner(@RequestBody OwnerModel owner){
//        if (ownerService.findNoOfOwner() == 0){
//            System.out.println(owner);
//            return ownerService.createOwner(owner);
//        }
//        else {
//            System.out.println("Owner already present");
//            // send 503
//            // return ownerService.getOwner();
//            return ownerService.findOwner();
//        }
//    }
//
//    @GetMapping("/getOwner")
//    public List<OwnerModel> getOwner(){
//        return ownerService.getOwner();
//    }
//
//    @GetMapping("/findNoOfOwner")
//    public int findNoOfOwner(){
//        if(ownerService.findNoOfOwner() == 1){
//            return 1;
//        }
//        else return 0;
//    }