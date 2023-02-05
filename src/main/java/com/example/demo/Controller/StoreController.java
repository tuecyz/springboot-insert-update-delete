package com.example.demo.Controller;
import com.example.demo.Model.*;
import com.example.demo.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@RestController
public class StoreController {

    @Autowired
    MySqlRepository mySqlRepository;

    @GetMapping("/get-all-addresses")
    public List<Address> getAllAddresses(HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        return mySqlRepository.findAll();
    }

    @GetMapping("/get-address/{identity}")
    public Address getSingleAddress(@PathVariable("identity") Integer id, HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        return mySqlRepository.findById(id).get();
    }

    @DeleteMapping("/remove/{id}")
    public HttpStatus deleteRow(@PathVariable("id") Integer id) {
        if (!mySqlRepository.findById(id).equals(Optional.empty())) {
            mySqlRepository.deleteById(id);
            return HttpStatus.OK;
        }
        return HttpStatus.BAD_REQUEST;
    }

    @PutMapping("/update/{id}")
    public Address updateAddress(@PathVariable("id") Integer id,
                                 @RequestBody Map<String, String> body, HttpServletResponse response) {

        Address current = mySqlRepository.findById(id).get();
        current.setEtkinlikadi(body.get("etkinlikadi"));
        current.setBaslangictarihi(body.get("baslangictarihi"));
        current.setBitistarihi(body.get("bitistarihi"));
        current.setKota(Integer.parseInt(body.get("kota")));
        current.setKatilimcisayisi(Integer.parseInt(body.get("katilimcisayisi")));
        mySqlRepository.save(current);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        return current;
    }

    @PostMapping("/add")
    public Address create(@RequestBody Map<String, String> body, HttpServletResponse response) {

        String etkinlikadi = body.get("etkinlikadi");
        String baslangictarihi = body.get("baslangictarihi");
        String bitistarihi = body.get("bitistarihi");
        Integer kota = Integer.parseInt(body.get("kota"));
        Integer katilimcisayisi = Integer.parseInt(body.get("katilimcisayisi"));
        Address newAddress = new Address(etkinlikadi, baslangictarihi, bitistarihi,kota,katilimcisayisi);
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        return mySqlRepository.save(newAddress);
    }
}