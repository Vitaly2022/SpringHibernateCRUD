package vit.repository;

import org.springframework.stereotype.Repository;
import vit.models.Developer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DeveloperRepositoryImpl implements DeveloperRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Developer> getAllDeveloper() {

        return entityManager.createQuery("from Developer ", Developer.class).getResultList();
    }

    @Override
    public List<Developer> findAllDeveloperById(long id) { // возможно здесь ошибка
        return entityManager.createQuery("from Developer where Developer.id=id", Developer.class).getResultList();
    }

    @Override
    public void createDeveloper(Developer developer) {
        entityManager.persist(developer);
        entityManager.flush();
    }

    @Override
    public void updateDeveloper(Developer developer) {
        entityManager.merge(developer);
        entityManager.flush();
    }

    @Override
    public Developer getDeveloper(long id) {
        return entityManager.find(Developer.class, id);
    }

    @Override
    public Developer deleteDeveloper(long id) throws NullPointerException {
        Developer developer = getDeveloper(id);
        if (null == developer) {
            throw new NullPointerException("Developer not found");
        }
        entityManager.remove(developer);
        entityManager.flush();
        return developer;
    }


}
