package interview.dao.impl;

import interview.dao.TourDao;
import interview.dao.mapper.TourMapper;
import interview.entity.Tour;
import interview.exception.DbOperationException;
import interview.exception.NotFoundException;
import org.apache.tomcat.jni.Local;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDateTime;

@Repository
public class TourDaoImpl implements TourDao {

    private JdbcTemplate jdbcTemplate;
    private TourMapper mapper;
    private Logger logger = LoggerFactory.getLogger(TourDaoImpl.class);

    @Autowired
    public TourDaoImpl(DataSource dataSource, TourMapper mapper) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.mapper = mapper;
    }

    @Override
    public Tour findByFields(int days, boolean hasTransfer, boolean hasBreakfast,
                             boolean hasLunch, boolean hasDinner, LocalDateTime departmentDate,
                             Long hotelId) {
        try {
            LocalDateTime finishDate = departmentDate.plusDays(days);
            return jdbcTemplate.queryForObject(Queries.SQL_FIND_BY_FIELDS, mapper,
                    days, hasTransfer, hasBreakfast, hasLunch, hasDinner, departmentDate, finishDate, hotelId);
        } catch (EmptyResultDataAccessException ex) {
            logger.error("Tour with parameters: days {}, hasTransfer {}, hasBreakfast {}, " +
                            "hasLunch {}, hasDinner {}, departmentDate{}, hotelId {} not found. Message: {}",
                    days, hasTransfer, hasBreakfast, hasLunch, hasDinner,departmentDate, hotelId,
                    ex.getLocalizedMessage());
            throw new NotFoundException("Tour not found");
        } catch (Exception e) {
            logger.error("Tour search error. Message: {}", e.getLocalizedMessage());
            throw new DbOperationException("Tour search error");
        }
    }

    private class Queries {
        static final String SQL_FIND_BY_FIELDS = "SELECT * FROM tours WHERE days = ? AND" +
                " has_transfer = ? AND has_breakfast = ? AND has_lunch = ? AND " +
                "has_dinner = ? AND department_date between ? and ? AND hotel_id = ?";
    }

}
