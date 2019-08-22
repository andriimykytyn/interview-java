package interview.dao.mapper;

import interview.entity.Check;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Component
public class CheckMapper implements RowMapper<Check> {
    @Override
    public Check mapRow(ResultSet resultSet, int i) throws SQLException {
        Check check = new Check();
        check.setId(resultSet.getLong("id"));
        check.setTotalPrice(resultSet.getDouble("total_price"));
        check.setCreated(resultSet.getObject("created", LocalDateTime.class));
        check.setCustomerId(resultSet.getLong("customer_id"));
        return check;
    }
}
