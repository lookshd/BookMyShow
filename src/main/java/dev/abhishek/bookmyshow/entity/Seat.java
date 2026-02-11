package dev.abhishek.bookmyshow.entity;

import dev.abhishek.bookmyshow.entity.constants.SeatType;

public class Seat extends BaseModel{
    private  int row;
    private  int column;
    private SeatType seatType;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
}
