package interview.dao.mapper;

import interview.entity.Hotel;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class HotelMapper implements RowMapper<Hotel> {
    @Override
    public Hotel mapRow(ResultSet resultSet, int i) throws SQLException {
        Hotel hotel = new Hotel();
        hotel.setId(resultSet.getLong("id"));
        hotel.setCountry(resultSet.getString("country"));
        hotel.setCity(resultSet.getString("city"));
        hotel.setEuropeanCountry(resultSet.getBoolean("is_european"));
        hotel.setVisaFeeRequired(resultSet.getBoolean("visa_fee_required"));
        hotel.setStars(resultSet.getInt("stars"));
        hotel.setInsuranceCostPerDay(resultSet.getDouble("insurance_cost_per_day"));
        return hotel;
    }
}
