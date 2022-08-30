package com.sunglowsys;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder ();
        String str = encoder.encode ("Adi@1234");
        System.out.println (str);
    }
}
