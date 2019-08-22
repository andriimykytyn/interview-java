package interview.dao.mapper;

import interview.entity.Room;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RoomMapper implements RowMapper<Room> {
    @Override
    public Room mapRow(ResultSet resultSet, int i) throws SQLException {
        Room room = new Room();
        room.setId(resultSet.getLong("id"));
        room.setRoomType(resultSet.getString("room_type"));
        room.setAmountOfBeds(resultSet.getInt("amount_of_beds"));
        room.setCostPerDay(resultSet.getDouble("cost_per_day"));
        room.setHotelId(resultSet.getLong("hotel_id"));
        return room;
    }
}
