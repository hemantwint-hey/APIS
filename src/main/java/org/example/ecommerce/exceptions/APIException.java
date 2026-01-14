package org.example.ecommerce.exceptions;

public class APIException extends  RuntimeException{
        APIException(){
        }
        public APIException(String message){
            super(message);
        }
}
