package interview.dao.impl;

import interview.dao.RoomDao;
import interview.dao.mapper.RoomMapper;
import interview.entity.Room;
import interview.exception.DbOperationException;
import interview.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class RoomDaoImpl implements RoomDao {

    private JdbcTemplate jdbcTemplate;
    private RoomMapper mapper;
    private Logger logger = LoggerFactory.getLogger(RoomDaoImpl.class);

    public RoomDaoImpl(DataSource dataSource, RoomMapper mapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.mapper = mapper;
    }

    @Override
    public Room findByFields(String roomType, int beds, Long hotelId) {
        try {
            return jdbcTemplate.queryForObject(Queries.SQL_FIND_BY_FIELDS, mapper,
                    roomType, beds, hotelId);
        } catch (EmptyResultDataAccessException ex) {
            logger.error("Room with parameters: room type {}, beds {}, hotelId {}, not found. Message: {}",
                    roomType, beds, hotelId, ex.getLocalizedMessage());
            throw new NotFoundException("Room not found");
        } catch (Exception e) {
            logger.error("Room search error. Message: {}", e.getLocalizedMessage());
            throw new DbOperationException("Room search error");
        }
    }

    private class Queries {
        static final String SQL_FIND_BY_FIELDS = "SELECT * FROM rooms " +
                "WHERE room_type = ? AND amount_of_beds = ? AND hotel_id = ?";
    }
}
