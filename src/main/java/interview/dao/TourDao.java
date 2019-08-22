package interview.dao;

import interview.entity.Tour;

import java.time.LocalDateTime;

public interface TourDao {

    Tour findByFields(int days, boolean hasTransfer,
                      boolean hasBreakfast, boolean hasLunch,
                      boolean hasDinner, LocalDateTime departmentDate, Long hotelId);

}
