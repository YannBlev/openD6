package bzh.amzerin.openD6.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import bzh.amzerin.openD6.bo.Universe;
import bzh.amzerin.openD6.service.UniverseService;


@Component
public class UniverseConverter implements Converter<String, Universe> {

    @Autowired
    private UniverseService universeService;


    @Override
    public Universe convert(String idTextFormat) {
        int id = Integer.parseInt(idTextFormat);
        return universeService.getUniverseById(id);
    }
}