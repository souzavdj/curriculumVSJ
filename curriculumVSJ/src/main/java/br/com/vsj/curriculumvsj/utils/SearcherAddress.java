/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vsj.curriculumvsj.utils;

import br.com.vsj.curriculumvsj.model.entity.Address;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import org.apache.log4j.Logger;

/**
 * Classe de utilidade que faz a busca binária a procura do cep.
 * @author vinicius
 * @version 1.0
 */
public class SearcherAddress {

    public static Address getAddressByZipCode(String zipCode) throws Exception {
        Address address;
        try {
            File file = new File("/media/vinicius/Meus arquivos/workspace/workspace NetBeans/curriculumVSJ/curriculumVSJ/src/main/webapp/Files/ZipCode/orderedZipCode.dat");
            //Ver como botar o endereço relacionado.
            RandomAccessFile f = new RandomAccessFile(file, "r");
            long last = f.length() / 300L;
            int zipCodeInt = Integer.parseInt(zipCode);
            address = RecursiveBinarySearch(f, 0, last, zipCodeInt);
            f.close();
        }catch(Exception e) {
            address = null;
            Logger lg = Logger.getLogger(SearcherAddress.class);
            lg.error("Exceção ao tentar buscar Cep. ", e);
            throw e;
        }
        return address;
    }

    private static Address RecursiveBinarySearch(RandomAccessFile f, long smaller, long bigger, int zipCodeToFind) throws IOException {
        long half = (bigger + smaller) / 2;
        f.seek(half * 300);
        AddressFound af = new AddressFound();
        af.readAddress(f);
        int halfValue = Integer.parseInt(af.getZipCode());
        if (smaller > bigger) {
            return null;
        } else if (halfValue == zipCodeToFind) {
            Address address = new Address();
            address.setStreet(af.getStreet().trim());
            address.setNeighborhood(af.getNeighborhood().trim());
            address.setCity(af.getCity().trim());
            address.setState(af.getState().trim());
            address.setCountry("BRASIL");
            return address;
        } else if (halfValue < zipCodeToFind) {
            return RecursiveBinarySearch(f, half + 1, bigger, zipCodeToFind);
        } else {
            return RecursiveBinarySearch(f, smaller, half - 1, zipCodeToFind);
        }
    }
}
