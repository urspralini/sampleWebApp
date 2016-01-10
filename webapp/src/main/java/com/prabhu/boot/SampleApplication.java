package com.prabhu.boot;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import org.glassfish.jersey.CommonProperties;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.ServerProperties;
import org.glassfish.jersey.server.validation.ValidationConfig;
import org.glassfish.jersey.server.validation.internal.InjectingConstraintValidatorFactory;
import org.hibernate.validator.internal.engine.DefaultParameterNameProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.ContextResolver;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * Created by prabhu on 1/2/16.
 */
@ApplicationPath("rest")
public class SampleApplication extends ResourceConfig {

    public SampleApplication() {
        //register for scan: package with resource classes
        packages("com.prabhu.rest");
        //register for scan: package with exception mapper classes
        packages("com.prabhu.exception.mappers");

        //for jersey bean validation
        register(ValidationConfigurationContextResolver.class);

        //configure common properties
        configureProperties();

        //configure jackson json provider
        register(configureAndGetJacksonJsonProvider());

    }

    private void configureProperties() {
        //disable the default moxy json feature
        property(CommonProperties.MOXY_JSON_FEATURE_DISABLE, true);
        //enable bean validation
        property(ServerProperties.BV_FEATURE_DISABLE, false);
        //send error when bean validation has failed
        property(ServerProperties.BV_SEND_ERROR_IN_RESPONSE, true);
    }

    private JacksonJsonProvider configureAndGetJacksonJsonProvider() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_EMPTY_JSON_ARRAYS, false);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

        mapper.setDateFormat(configureAndGetDateFormat());
        JacksonJsonProvider provider = new JacksonJsonProvider();
        provider.setMapper(mapper);
        return provider;
    }

    private DateFormat configureAndGetDateFormat() {
        final String DATE_FORMAT_ZONE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXX";
        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT_ZONE_FORMAT);
        dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        return dateFormat;
    }

    public static class ValidationConfigurationContextResolver implements ContextResolver<ValidationConfig> {
        @Context
        private ResourceContext resourceContext;

        public ValidationConfig getContext(Class<?> aClass) {
            final ValidationConfig config = new ValidationConfig();
            config.constraintValidatorFactory(resourceContext.getResource(InjectingConstraintValidatorFactory.class));
            config.parameterNameProvider(new DefaultParameterNameProvider());
            return config;
        }
    }
}
