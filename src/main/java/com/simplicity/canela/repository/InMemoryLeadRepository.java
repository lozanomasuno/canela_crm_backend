package com.simplicity.canela.repository;

import com.simplicity.canela.model.Lead;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class InMemoryLeadRepository implements LeadRepository {

    private final Map<String, Lead> store = new ConcurrentHashMap<>();

    @Override
    public Lead save(Lead lead) {
        store.put(lead.getId(), lead);
        return lead;
    }

    @Override
    public List<Lead> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public Optional<Lead> findById(String id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public void delete(String id) {
        store.remove(id);
    }
}
