package com.simplicity.canela.repository;

import com.simplicity.canela.model.Lead;

import java.util.List;
import java.util.Optional;

public interface LeadRepository {

    Lead save(Lead lead);

    List<Lead> findAll();

    Optional<Lead> findById(String id);

    void delete(String id);
}
