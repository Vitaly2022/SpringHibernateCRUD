package vit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vit.models.Developer;
import vit.repository.DeveloperRepository;

import java.util.List;

@Service
@Transactional
public class DeveloperServiceImpl implements DeveloperService {

    private final DeveloperRepository developerRepository;

    @Autowired
    public DeveloperServiceImpl(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    @Override
    public List<Developer> getAllDeveloper() {
        return developerRepository.getAllDeveloper();
    }

    @Override
    public List<Developer> getAllDeveloperByPosition(long id) {
        return developerRepository.findAllDeveloperById(id);
    }

    @Override
    public void createOrUpdateDeveloper(Developer developer) {
        if (developer.getId()==0) {
            createDeveloper(developer);
        } else {
            updateDeveloper(developer);
        }
    }

    public void createDeveloper(Developer developer) {
        developerRepository.createDeveloper(developer);
    }

    private void updateDeveloper(Developer developer) {

        developerRepository.updateDeveloper(developer);
    }

    @Override
    public Developer findDeveloper(long id) {
        return developerRepository.getDeveloper(id);
    }

    @Override
    public Developer deleteDeveloper(long id) {
        Developer developer = null;
        try {
            developer = developerRepository.deleteDeveloper(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return developer;
    }


}
