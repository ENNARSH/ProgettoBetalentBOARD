package com.progetto.betalent.board.service;


import com.progetto.betalent.board.dto.EmployeeDTO;
import com.progetto.betalent.board.dto.LoginDTO;
import com.progetto.betalent.board.payloadResponse.LoginMesage;

public interface EmployeeService {
    String addEmployee(EmployeeDTO employeeDTO);

    LoginMesage loginEmployee(LoginDTO loginDTO);


}
