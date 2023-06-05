package vit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vit.models.Developer;
import vit.models.Position;
import vit.repository.PositionRepository;

import java.util.List;

@Service
@Transactional
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    @Autowired
    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public List<Position> getAllPosition() {
        return positionRepository.getAllPosition();
    }

    @Override
    public void createOrUpdatePosition(Position position) {
        if (0 == position.getId()) {
            createPosition(position);
        } else {
            updatePosition(position);
        }
    }

    private void createPosition(Position position) {
        positionRepository.createPosition(position);
    }

    private void updatePosition(Position position) {

        positionRepository.updatePosition(position);
    }

    @Override
    public Position findPosition(long id) {
        return positionRepository.getPosition(id);
    }

    @Override
    public Position deletePosition(long id) {
        Position position = null;
        try {
            position = positionRepository.deletePosition(id);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
        return position;
    }
}
