package vit.repository;

import org.springframework.stereotype.Repository;
import vit.models.Position;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PositionRepositoryImpl implements PositionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Position> getAllPosition() {
        return entityManager.createQuery("from Position", Position.class).getResultList();
    }

    @Override
    public void createPosition(Position position) {
        entityManager.persist(position);
        entityManager.flush();
    }

    @Override
    public void updatePosition(Position position) {
        entityManager.merge(position);
        entityManager.flush();
    }

    @Override
    public Position getPosition(long id) {
        return entityManager.find(Position.class, id);
    }

    @Override
    public Position deletePosition(long id) throws NullPointerException {
        Position position = getPosition(id);
        if (null == position) {
            throw new NullPointerException("Position not found");
        }
        entityManager.remove(position);
        entityManager.flush();
        return position;
    }

}
