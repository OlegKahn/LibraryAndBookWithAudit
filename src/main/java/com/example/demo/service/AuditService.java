package com.example.demo.service;

import com.example.demo.entity.Audit;

public interface AuditService {

    Audit create(Class<?> someClass,long id);
}
