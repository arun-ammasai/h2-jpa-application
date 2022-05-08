package com.bcv.application.util;

import org.modelmapper.ModelMapper;
import javax.annotation.ManagedBean;

@ManagedBean
public class Mapper {
    public ModelMapper mapper(){
        return new ModelMapper();
    }
}
