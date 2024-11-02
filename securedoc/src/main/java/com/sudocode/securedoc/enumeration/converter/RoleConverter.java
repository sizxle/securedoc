package com.sudocode.securedoc.enumeration.converter;

import com.sudocode.securedoc.enumeration.Authority;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import javax.print.attribute.Attribute;
import java.util.stream.Stream;

/**
 * convert roles from data to java object, vice verse
 *
 */

@Converter(autoApply = true) //automatically runs the convertor
public class RoleConverter implements AttributeConverter<Authority,String> {


    @Override
    public String convertToDatabaseColumn(Authority authority) {
        
        if(authority == null){
            return null;
        }
        
        return authority.getValue();
    }

    @Override
    public Authority convertToEntityAttribute(String dbDataAuthority) {
        
        if(dbDataAuthority == null){
            return null;
        }

        return Stream.of(Authority.values()).filter(authority -> authority.getValue().equals(dbDataAuthority))
                .findFirst()
                .orElseThrow(()-> new IllegalArgumentException());
    }
}
