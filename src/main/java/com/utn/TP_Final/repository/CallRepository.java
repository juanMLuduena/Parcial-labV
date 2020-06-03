package com.utn.TP_Final.repository;


import com.utn.TP_Final.model.Call;
import com.utn.TP_Final.projections.UserAndPriceOfLastCall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CallRepository extends JpaRepository<Call, Integer> {

   // @Query(value = "select * from calls c join ")
   // List<Call> getBySourceNumber(String number);

    //NO OLVIDAR que en las proyecciones tiene que ser EXACTAMENTE el mismo nombre de variable y en el mismo orden
    @Query(value = "select u.firstname, u.dni, c.total_price as totalPrice from calls c" +
            " inner join telephone_lines t" +
            " on c.source_number = t.line_number" +
            " inner join users u" +
            " on t.id_user = u.id" +
            " order by c.id desc" +
            " limit 1;",nativeQuery = true)
   UserAndPriceOfLastCall getUserAndPriceOfLastCall();

}
