package interview.service.impl;

import interview.dao.CheckDao;
import interview.dao.HotelDao;
import interview.dao.RoomDao;
import interview.dao.TourDao;
import interview.dto.CheckDto;
import interview.dto.HotelCheckDto;
import interview.dto.OrderDto;
import interview.dto.TourCheckDto;
import interview.dto.mapper.CheckDtoMapper;
import interview.entity.*;
import interview.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;

@Service
public class CheckServiceImpl implements CheckService {

    private HotelDao hotelDao;
    private CheckDao checkDao;
    private TourDao tourDao;
    private RoomDao roomDao;
    private CheckDtoMapper mapper;

    @Autowired
    public CheckServiceImpl(HotelDao hotelDao, CheckDao checkDao,
                            TourDao tourDao, RoomDao roomDao, CheckDtoMapper mapper) {
        this.hotelDao = hotelDao;
        this.checkDao = checkDao;
        this.tourDao = tourDao;
        this.roomDao = roomDao;
        this.mapper = mapper;
    }

    @Override
    public CheckDto check(OrderDto orderDto, Customer customer) {
        CheckDto checkDto = new CheckDto();
        Long hotelId = hotelDao.findByFields(orderDto.getCountry(),
                orderDto.getCity(), orderDto.getHotelStars()).getId();
        Room room = roomDao.findByFields(orderDto.getRoomType(), orderDto.getBeds(), hotelId);
        double totalPrice = 0;
        double roomPrice = room.getCostPerDay() * orderDto.getDays();
        checkDto.setRoomPrice(roomPrice);
        double hotelPrice = checkHotel(orderDto).getHotelPriceTotal();
        checkDto.setHotelPrice(checkHotel(orderDto));
        double tourPrice = checkTour(orderDto).getTotalTourPrice();
        checkDto.setTourPrice(checkTour(orderDto));
        totalPrice = totalPrice + roomPrice + hotelPrice + tourPrice;
        checkDto.setpriceWithoutDiscount(totalPrice);
        if (customer.isCertified()) {
            checkDto.setCertificateDiscount(0.1);
            totalPrice = totalPrice - totalPrice * 0.1;
        }
        checkDto.setTotalPrice(totalPrice);
        checkDto.setCustomerId(customer.getId());
        Check check = checkDao.check(mapper.getCheck(checkDto));
        if (!customer.isCertified() && check.getCreated().getMonth() == Month.AUGUST && check.getCreated().getDayOfMonth() == 24) {
            checkDto.setTotalPrice(totalPrice - totalPrice * 0.1);
        }
        checkDto.setId(check.getId());
        checkDto.setCreated(check.getCreated());
        checkDto.setDepartmentDate(orderDto.getDepartmentDate());
        return checkDto;
    }

    @Override
    public HotelCheckDto checkHotel(OrderDto orderDto) {
        HotelCheckDto hotelCheckDto = new HotelCheckDto();
        hotelCheckDto.setStars(orderDto.getHotelStars());
        Hotel hotel = hotelDao.findByFields(orderDto.getCountry(), orderDto.getCity(), orderDto.getHotelStars());
        double totalHotelPrice = 0;
        double insuranceTotalPrice = hotel.getInsuranceCostPerDay() * orderDto.getDays();
        if (orderDto.getDays() > 7) {
            insuranceTotalPrice = insuranceTotalPrice - 10;
        } else if (orderDto.getDays() > 14) {
            insuranceTotalPrice = insuranceTotalPrice - 50;
        }

        hotelCheckDto.setInsurancePrice(insuranceTotalPrice);

        if (!hotel.isEuropeanCountry()) {
            hotelCheckDto.setWorldWideInsuranceMultiplier(0.1);
            insuranceTotalPrice = insuranceTotalPrice + insuranceTotalPrice *0.1;
        } if (hotel.isVisaFeeRequired()) {
            hotelCheckDto.setVisaFeePrice(50);
            totalHotelPrice = totalHotelPrice + 50;
        }
        totalHotelPrice = (totalHotelPrice + insuranceTotalPrice) * orderDto.getHotelStars();

        hotelCheckDto.setTotalInsurancePrice(insuranceTotalPrice);
        hotelCheckDto.setHotelPriceTotal(totalHotelPrice);
        return hotelCheckDto;
    }

    @Override
    public TourCheckDto checkTour(OrderDto orderDto) {
        TourCheckDto tourCheckDto = new TourCheckDto();
        tourCheckDto.setDays(orderDto.getDays());
        Long hotelId = hotelDao.findByFields(orderDto.getCountry(),
                orderDto.getCity(), orderDto.getHotelStars()).getId();
        Tour tour = tourDao.findByFields(orderDto.getDays(), orderDto.isHasTransfer(),
                orderDto.isHasBreakfast(), orderDto.isHasLunch(), orderDto.isHasDinner(),
                orderDto.getDepartmentDate(), hotelId);
        double totalTourPrice = 0;
        if (tour.isHasBreakfast()) {
            tourCheckDto.setBreakfastPrice(10*orderDto.getDays());
            totalTourPrice = totalTourPrice + 10*orderDto.getDays();
        } if (tour.isHasLunch()) {
            tourCheckDto.setLunchPrice(30*orderDto.getDays());
            totalTourPrice = totalTourPrice + 30*orderDto.getDays();
        } if (tour.isHasDinner()) {
            tourCheckDto.setDinnerPrice(15*orderDto.getDays());
            totalTourPrice = totalTourPrice + 15*orderDto.getDays();
        }

        if (!tour.isHasTransfer()) {
            tourCheckDto.setTransferPrice(100);
            totalTourPrice = totalTourPrice + 100;
        }

        tourCheckDto.setTotalTourPrice(totalTourPrice);
        return tourCheckDto;
    }

}
