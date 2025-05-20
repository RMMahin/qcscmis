package com.example.qcscmis.service;

import com.example.qcscmis.model.Quantaa;
import com.example.qcscmis.repository.QuantaaRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuantaaService {
    private  final QuantaaRepository repository;

    public QuantaaService(QuantaaRepository repository) {
        this.repository = repository;
    }

    public Quantaa createQuantaa(Quantaa quantaa) {
        return repository.save(quantaa);
    }

    public Quantaa getQuantaaById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Quantaa> getQuantaList(String key) {
        return repository.getQuantaaList(key);
    }

    public void deleteQuantaa(Long id) {
        repository.deleteById(id);
    }
}
