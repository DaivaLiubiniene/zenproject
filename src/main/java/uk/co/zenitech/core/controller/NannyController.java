package uk.co.zenitech.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.zenitech.core.model.Nanny;
import uk.co.zenitech.core.service.NannyService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/nannies")
public class NannyController {

    private final NannyService nannyService;

    public NannyController(NannyService nannyService){
        this.nannyService = nannyService;
    }

    @PreAuthorize(value = "hasRole('ADMIN') or hasAuthority('UID_' + #id)")
    @GetMapping("/{id}")
    public ResponseEntity<Nanny> getNannyById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(nannyService.getNannyById(id));
    }

    @GetMapping
    public ResponseEntity<List<Nanny>> getAllNannies() {
        return ResponseEntity.status(HttpStatus.OK).body(nannyService.getAllNannies());
    }

    @PostMapping
    public ResponseEntity<Nanny> addNanny(@RequestBody @Valid Nanny nanny) {
        return ResponseEntity.status(HttpStatus.CREATED).body(nannyService.addNanny(nanny));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteNannyById(@PathVariable Long id) {
        nannyService.deleteNannyById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
