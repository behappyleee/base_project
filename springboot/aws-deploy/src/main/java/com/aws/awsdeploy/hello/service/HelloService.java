package com.aws.awsdeploy.hello.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class HelloService {

    Logger logger = LoggerFactory.getLogger(HelloService.class);

    public void hello() {

    }

    public static void main(String[] args) throws IOException {
        InputStream is = new FileInputStream("Test");
        InputStreamReader ir = new InputStreamReader(is);

        // ir.read()




    }

}
