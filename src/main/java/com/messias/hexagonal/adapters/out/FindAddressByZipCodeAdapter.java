package com.messias.hexagonal.adapters.out;

import com.messias.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.messias.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.messias.hexagonal.adapters.out.client.response.AddressResponse;
import com.messias.hexagonal.application.core.domain.Address;
import com.messias.hexagonal.application.ports.out.FindAddressByZipCodeOutPutPort;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Log4j2
@Component
public class FindAddressByZipCodeAdapter implements FindAddressByZipCodeOutPutPort {

    private FindAddressByZipCodeClient findAddressByZipCodeClient;
    private AddressResponseMapper addressResponseMapper;

    @Autowired
    public FindAddressByZipCodeAdapter(FindAddressByZipCodeClient findAddressByZipCodeClient, AddressResponseMapper addressResponseMapper){
        this.findAddressByZipCodeClient = findAddressByZipCodeClient;
        this.addressResponseMapper = addressResponseMapper;
    }
    public Address find(String zipCode) {
        log.info("Buscando endereço para o CEP: {}", zipCode);
       AddressResponse anddressResponse = findAddressByZipCodeClient.find(zipCode);
       log.info("Endereço encontrado: {}", anddressResponse);
         Address address = addressResponseMapper.toAddress(anddressResponse);
         log.info("Endreço convertido para o modelo: {}", address);
        return address;
    }
}
