package com.example.service;

import com.example.model.DataModel;
import com.example.model.Variable;

import java.util.List;

public interface DataModelService {
    void saveData(DataModel data);
    void deleteData(Long id);
    DataModel getData(Long id);
    List<DataModel> getAllData();
    void updateData(Long id, DataModel newData);
      boolean checkExistence(int deviceId, String name, String password);
	void saveVariable(Variable variable);

      
}
