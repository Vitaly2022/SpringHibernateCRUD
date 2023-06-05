package vit.repository;

import vit.models.Developer;

import java.util.List;

public interface DeveloperRepository {

    List<Developer> getAllDeveloper();

    List<Developer> findAllDeveloperById(long id);

    void createDeveloper(Developer user);

    void updateDeveloper(Developer user);

    Developer getDeveloper(long id);

    Developer deleteDeveloper(long id);
}
