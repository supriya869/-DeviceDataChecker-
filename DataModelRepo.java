package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.DataModel;

@Repository
public interface DataModelRepo extends JpaRepository<DataModel, Long> {

	boolean existsByDeviceIDAndNameAndPassword(int deviceId, String name, String password);
    // Define custom query methods if needed
}
