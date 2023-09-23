package com.example.springapplication_demo_newman.service;

import com.example.springapplication_demo_newman.model.Response;
import com.example.springapplication_demo_newman.repository.EvenOddRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class EvenOddServiceImpl implements EvenOddService{

    private final EvenOddRepository evenOddRepository;

    @Override
    public Response isNameLengthEvenOrOdd(String name) {
        Integer num = this.evenOddRepository.findTheeLengthOfName(name);
        String result =num % 2 == 0 ? "Even" :"Odd";
        Response res = new Response();
        res.setEvenOrOdd(result);
        return res;
    }
}
