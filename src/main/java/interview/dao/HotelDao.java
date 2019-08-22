package interview.dao;

import interview.entity.Hotel;

public interface HotelDao {

    Hotel findByFields(String country, String city, int stars);

}
