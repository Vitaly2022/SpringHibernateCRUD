package vit.repository;

import vit.models.Developer;
import vit.models.Position;

import java.util.List;

public interface PositionRepository {

    List<Position> getAllPosition();

    void createPosition(Position position);

    void updatePosition(Position position);

    Position getPosition(long id);

    Position deletePosition(long id);

}
