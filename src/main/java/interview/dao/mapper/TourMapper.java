package interview.dao.mapper;

import interview.entity.Tour;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class TourMapper implements RowMapper<Tour> {
    @Override
    public Tour mapRow(ResultSet resultSet, int i) throws SQLException {
        Tour tour = new Tour();
        tour.setId(resultSet.getLong("id"));
        tour.setDays(resultSet.getInt("days"));
        tour.setHasTransfer(resultSet.getBoolean("has_transfer"));
        tour.setHasBreakfast(resultSet.getBoolean("has_breakfast"));
        tour.setHasLunch(resultSet.getBoolean("has_lunch"));
        tour.setHasDinner(resultSet.getBoolean("has_dinner"));
        tour.setDepartmentDate(resultSet.getObject("department_date", LocalDateTime.class));
        tour.setHotelId(resultSet.getLong("hotel_id"));
        return tour;
    }
}
