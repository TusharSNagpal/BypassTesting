package com.example.bypasstesting.services.impl;

import com.example.bypasstesting.entities.Bookings;
import com.example.bypasstesting.payloads.BookingsDto;
import com.example.bypasstesting.repositories.BookingsRepo;
import com.example.bypasstesting.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.ReadOnlyFileSystemException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {
    @Autowired
    private BookingsRepo bookingsRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BookingsDto newBooking(BookingsDto bookingsDto){
        Bookings bookings = this.modelMapper.map(bookingsDto, Bookings.class);
        Bookings createBooking = this.bookingsRepo.save(bookings);
        return this.modelMapper.map(createBooking, BookingsDto.class);
    }

    @Override
    public List<BookingsDto> getBookingsByVehicleRegNo(String vehicleRegNo) {
        List<Bookings> bookingsList = bookingsRepo.findAllBookingsByVehicleRegNo(vehicleRegNo);
        return bookingsList.stream().map(bookings -> this.modelMapper.map(bookings, BookingsDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BookingsDto> getOnGoingBooking(Integer customerId){
        List<Bookings> bookingsList = bookingsRepo.findOngoingBookingsByCustomerId(customerId);
        for(Bookings booking: bookingsList){
            Date curDate = new Date();
            Date inDate = booking.getIn_date();
            long difference = Math.abs(curDate.getTime() - inDate.getTime());
            long differenceDates = difference / (24 * 60 * 60 * 1000);
            long price = 50*differenceDates;
            booking.setPrice(Long.toString(price));
        }
        return bookingsList.stream().map(bookings -> this.modelMapper.map(bookings, BookingsDto.class)).collect(Collectors.toList());
    }

    @Override
    public BookingsDto goingOut(Integer bookingId, String price){
        Bookings booking = this.bookingsRepo.findById(bookingId).orElseThrow(()->new ReadOnlyFileSystemException());
        booking.setPrice(price);
        booking.setOut_date(new Date());
        Bookings updatedBooking = this.bookingsRepo.save(booking);
        return this.modelMapper.map(updatedBooking, BookingsDto.class);
    }

    @Override
    public List<BookingsDto> pastBookings(Integer customerId){
        List<Bookings> bookingsList = this.bookingsRepo.findBookingsByOutDateAndCustomerId(customerId);
        return bookingsList.stream().map(bookings -> this.modelMapper.map(bookings, BookingsDto.class)).collect(Collectors.toList());
    }
}
