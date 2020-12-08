package de.gedoplan.ged.angular.www.utils;

import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

import javax.enterprise.inject.Produces;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

@Provider
public class JacksonContextResolver implements ContextResolver<ObjectMapper> {

    private ObjectMapper mapper;

    @Override
    public ObjectMapper getContext(Class<?> type) {
        if (this.mapper == null) {
            this.mapper = new ObjectMapper();
            Hibernate5Module hibernateModule = new Hibernate5Module();
            mapper.registerModule(hibernateModule);
            mapper.configure(MapperFeature.DEFAULT_VIEW_INCLUSION, false);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            this.mapper.setDateFormat(df);
        }
        return this.mapper;
    }

    @Produces
    public ObjectMapper getObjectMapper() {
        return getContext(null);
    }
}
