package com.frank.com.frank.controller;

import com.frank.com.frank.domain.Employee;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import javax.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {

  @Value("${jdbc.database.url}")
  private String dataSource;

  @RequestMapping(method= RequestMethod.GET, path="/employees/{empNo}")
  public ResponseEntity getEmployees(@PathVariable("empNo") String empNo) {

    final Employee e1 = Employee.builder().name("Frank").salary(55000).build();
    final Employee e2 = Employee.builder().name("Estela").salary(99000).build();
    final List<Employee> employeeList = Arrays.asList(e1, e2);

    SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
    Date date = new Date(System.currentTimeMillis());

    return ResponseEntity.ok().body(
        "Employee name: " + employeeList.get(Integer.valueOf(empNo)).getName()
            + "<br><br>Employee salary: RM" + employeeList.get(Integer.valueOf(empNo)).getSalary()
            + "<br><br>Timestamp: " + formatter.format(date)
    + "<br><br>Database url: " + dataSource);
  }
}
