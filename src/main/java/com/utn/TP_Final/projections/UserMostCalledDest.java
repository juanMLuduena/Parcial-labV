package com.utn.TP_Final.projections;

public interface UserMostCalledDest {

    String getFirstName();
    String getLastName();
    String getDest(); //num de telefono

    void setFirstName(String firstName);
    void setLastName(String lastName);
    void setDest(String lineNumber);
}
