package interview.dao;

import interview.entity.Room;
import interview.entity.RoomType;

public interface RoomDao {

    Room findByFields(String roomType, int beds, Long hotelId);

}
