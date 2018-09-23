package com.example.storeapi.model;

import org.modelmapper.Converter;
import org.modelmapper.MappingException;
import org.modelmapper.PropertyMap;
import org.modelmapper.spi.MappingContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ItemDTO2ItemMapper extends PropertyMap<ItemDTO, Item> {
    private final static String DATE_FORMAT = "dd/MM/yyyy";
    private LocalDate localDate;
    private DateTimeFormatter dateTimeFormatter;

    private Converter<String, Item.ItemType> assetTypeConverter = (MappingContext<String, Item.ItemType> context) ->
            Item.ItemType.valueOf(context.getSource());


    private Converter<String, LocalDate> dateConverter = (MappingContext<String, LocalDate> context) ->
            localDate.parse(context.getSource(), dateTimeFormatter.ofPattern(DATE_FORMAT));

    @Override
    protected void configure() throws MappingException{
        map().setSerialNumber(source.getSerialNumber());
        using(assetTypeConverter).map(source.getItemType()).setItemType(null);
        using(dateConverter).map(source.getWarrantyExpirationDate()).setWarrantyExpirationDate(null);
    }
}





