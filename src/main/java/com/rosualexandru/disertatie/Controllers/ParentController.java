package com.rosualexandru.disertatie.Controllers;

import com.rosualexandru.disertatie.Model.Parent;
import com.rosualexandru.disertatie.Services.ParentService;
import com.rosualexandru.disertatie.StudentValidator.ParentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/school/parents")
public class ParentController {

    private ParentService parentService;
    private ParentValidator parentValidator;

    @Autowired
    public void ParentService(ParentService parentService) {
        this.parentService = parentService;
    }

    @Autowired
    public void ParentValidator(ParentValidator parentValidator) {
        this.parentValidator = parentValidator;
    }

    @PostMapping()
    public ResponseEntity<String> createParent(@RequestBody Parent parent) {

        parentValidator.validate(parent);

        try {
            Parent createdParent = parentService.createParent(parent);
            return new ResponseEntity<>(createdParent.toString(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to create parent: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
