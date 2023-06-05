package vit.service;

import vit.models.Developer;

import java.util.List;

public interface DeveloperService {

    List<Developer> getAllDeveloper();

    List<Developer> getAllDeveloperByPosition(long id);

    Developer findDeveloper (long id);

    Developer deleteDeveloper(long parseUnsignedInt);

    void createOrUpdateDeveloper(Developer developer);

    void createDeveloper(Developer developer);
}
