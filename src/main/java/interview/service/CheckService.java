package interview.service;

import interview.dto.CheckDto;
import interview.dto.HotelCheckDto;
import interview.dto.OrderDto;
import interview.dto.TourCheckDto;
import interview.entity.Customer;

public interface CheckService {

    CheckDto check(OrderDto orderDto, Customer customer);

    HotelCheckDto checkHotel(OrderDto orderDto);

    TourCheckDto checkTour(OrderDto orderDto);

}
