package uk.co.zenitech.core.service;

import org.springframework.stereotype.Service;
import uk.co.zenitech.core.model.Nanny;
import uk.co.zenitech.core.model.Parent;
import uk.co.zenitech.core.repository.ParentRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ParentService {

    private final ParentRepository parentRepository;

    public ParentService(ParentRepository parentRepository) {
        this.parentRepository = parentRepository;
    }

    @Transactional
    public Parent getParentById(Long id) {
        return parentRepository.getById(id);
    }

    @Transactional
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    @Transactional
    public Parent addParent(Parent parent) {
        return parentRepository.save(parent);
    }

    @Transactional
    public void deleteParentById(Long id) {
        parentRepository.deleteById(id);
    }
}
