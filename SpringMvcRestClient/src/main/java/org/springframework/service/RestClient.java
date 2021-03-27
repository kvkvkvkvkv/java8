package org.springframework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.logging.Logger;

@Service
public class RestClient {

    Logger log = Logger.getLogger("RestClient");
    @Autowired
    RestTemplate restTemplate;

    @Value("url")
    String url;

    public Employee getEmployee(Integer id){
//        ParameterizedTypeReference<List<Employee>> parameterizedTypeReference = new ParameterizedTypeReference<List<Employee>>() {};
//        ResponseEntity<List<Employee>> employees = restTemplate.execute(url, HttpMethod.GET,null, parameterizedTypeReference);

        log.info("******************url ="+url+"/"+id);
        ResponseEntity<Employee> employees = restTemplate.getForEntity("http://localhost:8080/SpringMVC/rest/emp/"+id,Employee.class);
        return employees.getBody();
    }

    public List<Employee> getEmployees(){
        ParameterizedTypeReference<List<Employee>> parameterizedTypeReference = new ParameterizedTypeReference<List<Employee>>() {};
        ResponseEntity<List<Employee>> employees = restTemplate.exchange("http://localhost:8080/SpringMVC/rest/emp/",HttpMethod.GET,null, parameterizedTypeReference);
        return employees.getBody();
    }

    public Employee postEmp(Employee employee){
        ResponseEntity<Employee> responseEntity = new ResponseEntity<Employee>(employee, HttpStatus.CREATED);
        ResponseEntity<Employee> employees = restTemplate.postForEntity("http://localhost:8080/SpringMVC/rest/emp/",responseEntity,Employee.class);
        return employees.getBody();
    }

    public void putEmp(Employee employee){
        ResponseEntity<Employee> responseEntity = new ResponseEntity<Employee>(employee, HttpStatus.OK);
        restTemplate.put("http://localhost:8080/SpringMVC/rest/emp/",responseEntity,Employee.class);
    }

    public void delEmp(Integer id){
        restTemplate.delete("http://localhost:8080/SpringMVC/rest/emp/"+id);
    }

}
