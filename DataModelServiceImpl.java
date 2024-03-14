package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.model.DataModel;
import com.example.model.Variable;
import com.example.repo.DataModelRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class DataModelServiceImpl implements DataModelService {

    private final DataModelRepo dataRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public DataModelServiceImpl(DataModelRepo dataRepository) {
        this.dataRepository = dataRepository;
    }

    @Override
    public void saveData(DataModel data) {
        dataRepository.save(data);
    }

    @Override
    public void deleteData(Long id) {
        dataRepository.deleteById(id);
    }

    @Override
    public DataModel getData(Long id) {
        Optional<DataModel> optionalData = dataRepository.findById(id);
        return optionalData.orElse(null);
    }

    @Override
    public List<DataModel> getAllData() {
        return dataRepository.findAll();
    }

    @Override
    public void updateData(Long id, DataModel newData) {
        Optional<DataModel> optionalData = dataRepository.findById(id);
        if (optionalData.isPresent()) {
            DataModel existingData = optionalData.get();
            // Update fields of existingData with newData
            // Example: existingData.setDatetime(newData.getDatetime());
            dataRepository.save(existingData);
        }
    }
    
    public boolean checkExistence(int deviceId, String name, String password) {
        return dataRepository.existsByDeviceIDAndNameAndPassword(deviceId, name, password);
    }
   

    @Override
    public void saveVariable(Variable variable) {
        entityManager.persist(variable);
    } 
    
}
