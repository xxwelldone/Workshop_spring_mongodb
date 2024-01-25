package com.xxwelldone.workshopmongo.controller.exception;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class URL {
    public static String decodeParam(String title){
        try {
          return  URLDecoder.decode(title, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }
}
