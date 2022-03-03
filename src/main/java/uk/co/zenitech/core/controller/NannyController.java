package uk.co.zenitech.core.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.co.zenitech.core.model.Nanny;
import uk.co.zenitech.core.service.NannyService;

@RestController
@RequestMapping("/nannies")
public class NannyController {

    private final NannyService nannyService;

    public NannyController(NannyService nannyService){
        this.nannyService = nannyService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nanny> getNannyById(@PathVariable Long id){
        return new ResponseEntity<>(nannyService.getNannyById(id), HttpStatus.OK);
    }


}
