package com.adobe.panchtantra.mapper;

import com.adobe.panchtantra.entity.BookingEntity;
import com.adobe.panchtantra.model.BookingModel;
import com.adobe.panchtantra.model.Bookings;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Component
public class BookingMapper {

    public Bookings convertListOfBookingToBookings(List<BookingEntity> bookingEntityList) {
        if(CollectionUtils.isEmpty(bookingEntityList)) {
            return null;
        }
        Bookings bookings = new Bookings();
        bookingEntityList.stream().forEach(bookingEntity -> bookings.add(convertBookingToBookingModel(bookingEntity)));
        return bookings;
    }

    public BookingModel convertBookingToBookingModel(BookingEntity bookingEntity) {
        if(bookingEntity == null) {
            return null;
        }

        BookingModel bookingModel = new BookingModel();
        bookingModel.
                id(bookingEntity.getId()).
                noOfSeats(bookingEntity.getNoOfSeats()).
                startDate(bookingEntity.getBookedAt().toString()).
                endDate(bookingEntity.getExpiresAt().toString()).
                status(bookingEntity.getStatus());

        return bookingModel;
    }
}
