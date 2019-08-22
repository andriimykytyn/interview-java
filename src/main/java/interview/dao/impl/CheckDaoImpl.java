package interview.dao.impl;

import interview.dao.CheckDao;
import interview.entity.Check;
import interview.exception.DbOperationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public class CheckDaoImpl implements CheckDao {

    private JdbcTemplate jdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(CheckDaoImpl.class);

    public CheckDaoImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Check check(Check check) {
        try {
            KeyHolder holder = new GeneratedKeyHolder();
            LocalDateTime currentDate = LocalDateTime.now();
            jdbcTemplate.update(con -> createStatement(check, currentDate, con), holder);
            check.setCreated(currentDate);
            check.setId(Optional.ofNullable(holder.getKey()).map(Number::longValue)
            .orElseThrow(() -> new DbOperationException("Save check exception. Autogenerated key is null")));

        } catch (Exception e) {
            logger.error("Save check exception. Message {}", e.getLocalizedMessage());
            throw new DbOperationException("Save check exception");
        } return check;
    }

    private PreparedStatement createStatement(Check check, LocalDateTime currentDate, Connection con) throws SQLException {
            PreparedStatement ps = con.prepareStatement(Queries.SQL_CREATE_CHECK, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, check.getTotalPrice());
            ps.setObject(2, currentDate);
            ps.setLong(3, check.getCustomerId());
            return ps;
    }

    private class Queries {
        static final String SQL_CREATE_CHECK = "INSERT INTO checks(total_price, created, customer_id) " +
                "VALUES(?,?,?)";
    }
}