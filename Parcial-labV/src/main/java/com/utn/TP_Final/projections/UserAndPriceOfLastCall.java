package com.utn.TP_Final.projections;

public interface UserAndPriceOfLastCall {

    String getFirstName();
    String getDni();
    float getTotalPrice();


    void setFirstName(String firstName);
    void setDni(String dni);
    void setTotalPrice(float totalPrice);
}
