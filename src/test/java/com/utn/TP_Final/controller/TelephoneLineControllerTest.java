package com.utn.TP_Final.controller;

import com.utn.TP_Final.exceptions.WrongPrefixException;
import com.utn.TP_Final.model.TelephoneLine;
import com.utn.TP_Final.service.TelephoneLineService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.initMocks;

public class TelephoneLineControllerTest {

    @Autowired
    public TelephoneLineController telephoneLineController;

    @Mock
    public TelephoneLineService telephoneLineService;

    @Before
    public void startUp(){
        initMocks(this);
        this.telephoneLineController=new TelephoneLineController(telephoneLineService);
    }

    @Test
    public void findAllByPrefixTest() throws WrongPrefixException {

        List<TelephoneLine> telephones = new ArrayList<TelephoneLine>();

        telephones.add(new TelephoneLine(1,"2215908654",null,null,null,null));

        when(telephoneLineService.findAllByPrefix("221")).thenReturn(telephones);


        assertEquals(1,telephoneLineService.findAllByPrefix("221").size());
        verify(telephoneLineService,times(1)).findAllByPrefix("221");


    }


}
