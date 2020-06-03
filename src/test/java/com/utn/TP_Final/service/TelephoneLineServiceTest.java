package com.utn.TP_Final.service;

import com.utn.TP_Final.exceptions.WrongPrefixException;
import com.utn.TP_Final.model.TelephoneLine;
import com.utn.TP_Final.repository.TelephoneLineRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class TelephoneLineServiceTest {
    @Autowired
    TelephoneLineService telephoneLineService;

    @Mock
    TelephoneLineRepository telephoneLineRepository;

    @Before
    public void setUp(){
        initMocks(this);
        telephoneLineService= new TelephoneLineService(telephoneLineRepository);
    }

    @Test
    public void findAllByPrefixTest() throws WrongPrefixException {

        List<TelephoneLine> telephones = new ArrayList<TelephoneLine>();

        telephones.add(new TelephoneLine(1,"2215908654",null,null,null,null));
        telephones.add(new TelephoneLine(3,"2215908694",null,null,null,null));
        telephones.add(new TelephoneLine(5,"2215908624",null,null,null,null));



        when(telephoneLineRepository.findByLineNumberStartsWith("221")).thenReturn(telephones);

        List<TelephoneLine> telephonesByPrefix = telephoneLineService.findAllByPrefix("221");

        assertEquals(3,telephonesByPrefix.size());
        verify(telephoneLineRepository, times(1)).findByLineNumberStartsWith("221");

    }

}
