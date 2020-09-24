package team.TAF.trill.service;

import team.TAF.trill.dto.Result;

import javax.servlet.http.HttpServletRequest;

public interface UserService {
    Result login(String username, String password, String code, HttpServletRequest request);
}
