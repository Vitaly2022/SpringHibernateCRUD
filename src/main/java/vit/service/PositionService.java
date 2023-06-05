package vit.service;

import vit.models.Developer;
import vit.models.Position;

import java.util.List;

public interface PositionService {

    List<Position> getAllPosition();

    Position findPosition (long id);

    Position deletePosition(long parseUnsignedInt);

    void createOrUpdatePosition(Position position);
}
