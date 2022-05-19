package uk.co.zenitech.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.zenitech.core.model.Parent;
import uk.co.zenitech.core.service.ParentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/parents")
public class ParentController {

    private final ParentService parentService;

    public ParentController(ParentService parentService){
        this.parentService = parentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Parent> getParentById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(parentService.getParentById(id));
    }

    @GetMapping
    public ResponseEntity<List<Parent>> getAllParents() {
        return ResponseEntity.status(HttpStatus.OK).body(parentService.getAllParents());
    }

    @PostMapping
    public ResponseEntity<Parent> addParent(@RequestBody @Valid Parent parent) {
        return ResponseEntity.status(HttpStatus.CREATED).body(parentService.addParent(parent));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteParentById(@PathVariable Long id) {
        parentService.deleteParentById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
