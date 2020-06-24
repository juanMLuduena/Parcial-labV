package com.utn.TP_Final.repository;

import com.utn.TP_Final.exceptions.NoDataException;
import com.utn.TP_Final.exceptions.WrongPrefixException;
import com.utn.TP_Final.model.TelephoneLine;
import com.utn.TP_Final.projections.MostAndLeastUsedLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TelephoneLineRepository extends JpaRepository<TelephoneLine, Integer> {

    @Query(value = "select * from telephone_lines where line_number = ?1", nativeQuery = true)
    List<TelephoneLine> findByLineNumber(String lineNumber);

    @Query(value = "remove from telephone_lines where line_number = ?1", nativeQuery = true)
    void delete(String lineNumber);

    @Query(value = "update telephone_lines set status = 'SUSPENDED' where line_number = ?1", nativeQuery = true)
    void suspendTelephoneLine(String lineNumber);

    @Query(value = "update telephone_lines set status = 'ACTIVE' where line_number = ?1", nativeQuery = true)
    void activeTelephoneLine(String lineNumber);

    @Query(value = "select * from telephone_lines where line_number like '?1%'", nativeQuery = true)
    List<TelephoneLine> findAllByPrefix(String prefix);

    @Query(value = "select * from telephone_lines",nativeQuery = true)
    List<TelephoneLine> findAll();

    //si comentas la query es exactamente lo mismo
    @Query(value = "select * from telephone_lines where line_number like ?1%",nativeQuery = true)
    List<TelephoneLine> findByLineNumberStartsWith(String prefix) throws WrongPrefixException;

    @Query(value = " (select t.line_number as mostUsedTelephoneLine " +
            " from telephone_lines t " +
            " inner join calls c on t.line_number = c.source_number"+
            " group by t.id order by count(t.id) desc limit 1)"+
            " UNION"+
            " (select t.line_number as leastUsedTelephoneLine"+
            " from telephone_lines t"+
            " inner join calls c on t.line_number = c.source_number"+
            " group by t.id order by count(t.id) asc limit 1)",nativeQuery = true)
    MostAndLeastUsedLine findMostAndLeastUsedTelephoneLine() throws NoDataException;

}
