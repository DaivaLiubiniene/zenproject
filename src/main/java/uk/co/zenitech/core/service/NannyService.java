package uk.co.zenitech.core.service;

import org.springframework.stereotype.Service;
import uk.co.zenitech.core.model.Nanny;
import uk.co.zenitech.core.repository.NannyRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class NannyService {

    private final NannyRepository nannyRepository;

    public NannyService(NannyRepository nannyRepository) {
        this.nannyRepository = nannyRepository;
    }

    @Transactional
    public Nanny getNannyById(Long id) {
        return nannyRepository.getById(id);
    }

    @Transactional
    public List<Nanny> getAllNannies() {
        return nannyRepository.findAll();
    }

    @Transactional
    public Nanny addNanny(Nanny nanny) {
        return nannyRepository.save(nanny);
    }

    @Transactional
    public void deleteNannyById(Long id) {
       nannyRepository.deleteById(id);
    }
}
