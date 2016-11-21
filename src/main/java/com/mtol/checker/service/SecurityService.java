package com.mtol.checker.service;

/**
 * This class
 */
public interface SecurityService {
    String findLoggedInEamils();
    void autologin(String email, String password);
}
