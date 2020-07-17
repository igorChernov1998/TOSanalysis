package ru.igor.tosamara.classifiers.parsers;

import ru.igor.tosamara.Configuration;
import ru.igor.tosamara.classifiers.xml.stop.Stops;

import javax.xml.bind.JAXB;
import java.io.File;

public class StopParser extends Parser<Stops> {
    @Override
    protected String getPath() {
        return Configuration.STOPS_CLASSIFIER_PATH;
    }

    public Stops parseFromFile(){
        try{
            return JAXB.unmarshal(new File(getPath()), Stops.class);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
