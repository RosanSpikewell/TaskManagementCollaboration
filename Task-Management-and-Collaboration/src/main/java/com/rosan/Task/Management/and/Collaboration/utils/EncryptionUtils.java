package com.rosan.Task.Management.and.Collaboration.utils;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class EncryptionUtils {
    public String passwordEncoder(String plainPassword){
            return BCrypt.hashpw(plainPassword,BCrypt.gensalt(12));
    }

    public Boolean verifyPassowrd(String plainPassword,String hashedPassword)
    {
        return BCrypt.checkpw(plainPassword,hashedPassword);
    }
}
