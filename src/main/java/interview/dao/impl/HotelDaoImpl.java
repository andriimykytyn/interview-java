package interview.dao.impl;

import interview.dao.HotelDao;
import interview.dao.mapper.HotelMapper;
import interview.entity.Hotel;
import interview.exception.DbOperationException;
import interview.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class HotelDaoImpl implements HotelDao {

    private JdbcTemplate jdbcTemplate;
    private Logger logger = LoggerFactory.getLogger(HotelDaoImpl.class);
    private HotelMapper mapper;

    @Autowired
    public HotelDaoImpl(DataSource dataSource, HotelMapper mapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.mapper = mapper;
    }

    @Override
    public Hotel findByFields(String country, String city, int stars) {
        try {
            return jdbcTemplate.queryForObject(Queries.SQL_FIND_BY_FIELDS, mapper, country, city, stars);
        } catch (EmptyResultDataAccessException ex) {
            logger.error("Hotel with parameters: country {}, city {}, stars {} not found. Message: {}",
                    country, city, stars, ex.getLocalizedMessage());
            throw new NotFoundException("Hotel not found");
        } catch (Exception e) {
            logger.error("Hotel search error. Message: {}", e.getLocalizedMessage());
            throw new DbOperationException("Hotel search error");
        }
    }

    private class Queries {
        static final String SQL_FIND_BY_FIELDS = "SELECT * FROM hotels " +
                "WHERE country = ? AND city = ? AND stars = ?";
    }

}
