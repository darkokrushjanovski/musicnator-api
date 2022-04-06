package com.krushjanovski.musicnator.service;

import com.krushjanovski.musicnator.security.AuthenticatedPrincipal;

public interface AuthService {

  AuthenticatedPrincipal getAuthenticatedPrincipal();

  String login(String email, String password);

}
