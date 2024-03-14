package com.example.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.DataModel;
import com.example.model.Variable;
import com.example.service.DataModelService;

@RestController
//@RequestMapping("/api/data")
public class DataModelController {

    private final DataModelService dataService;

    public DataModelController(DataModelService dataService) {
        this.dataService = dataService;
    }

    @PostMapping
    public ResponseEntity<String> saveData(@RequestBody DataModel data) {
        boolean exists = dataService.checkExistence(data.getDeviceID(),data.getName(), data.getPassword());
        if (exists) {
            dataService.saveData(data);
            return ResponseEntity.status(HttpStatus.CREATED).body("Data saved successfully");
        } else {
            dataService.saveData(data);
            return ResponseEntity.status(HttpStatus.CREATED).body("Data saved successfully without variable");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteData(@PathVariable Long id) {
        dataService.deleteData(id);
        return ResponseEntity.status(HttpStatus.OK).body("Data deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataModel> getData(@PathVariable Long id) {
        DataModel data = dataService.getData(id);
        if (data != null) {
            return ResponseEntity.status(HttpStatus.OK).body(data);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping
    public ResponseEntity<List<DataModel>> getAllData() {
        List<DataModel> dataList = dataService.getAllData();
        return ResponseEntity.status(HttpStatus.OK).body(dataList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateData(@PathVariable Long id, @RequestBody DataModel newData) {
        dataService.updateData(id, newData);
        return ResponseEntity.status(HttpStatus.OK).body("Data updated successfully");
    }

    @GetMapping("/checkExistence/{deviceId}/{name}/{password}")
    public ResponseEntity<String> checkExistence(@PathVariable int deviceId, @PathVariable String name, @PathVariable String password) {
        boolean exists = dataService.checkExistence(deviceId, name, password);
        if (exists) {
            return ResponseEntity.ok("Data exists");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/variables")
    public ResponseEntity<String> saveVariable(@RequestBody Variable variable) {
        dataService.saveVariable(variable);
        return ResponseEntity.status(HttpStatus.CREATED).body("Variable saved successfully");
    }
}
