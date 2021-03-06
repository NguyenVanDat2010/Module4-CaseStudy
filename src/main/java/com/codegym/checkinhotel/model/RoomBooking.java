package com.codegym.checkinhotel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@Entity
@Table(name = "room_booking")
@NoArgsConstructor
@AllArgsConstructor
public class RoomBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "booking_date")
    @CreationTimestamp
    private Timestamp bookingDate;
    @Column(name = "checkin_date", nullable = false)
    private String checkinDate;
    @Column(name = "checkout_date", nullable = false)
    private String checkoutDate;
    @Column
    @Type(type = "text")
    private String note;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private AppUser user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "room_id",nullable = false)
    @JsonIgnoreProperties(value = "room_booking")
    private Room room;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "room_booking_room",
//            joinColumns = {@JoinColumn(name = "room_booking_id")},
//            inverseJoinColumns = {@JoinColumn(name = "room_id")})
//    @JsonIgnoreProperties(value = "room_booking")
//    private List<Room> rooms;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Timestamp bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    public String getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public AppUser getUser() {
        return user;
    }

    public void setUser(AppUser user) {
        this.user = user;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Room booking [id=" + id
                + ", booking date=" + bookingDate
                + ", checkin date=" + checkinDate
                + ", checkout date=" + checkoutDate
                + ", note=" + note
                + "]";
    }
}
