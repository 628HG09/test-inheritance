package com.example.relations.repositories;

import com.example.relations.models.Passagier;

import javax.transaction.Transactional;

@Transactional
public interface PassagierRepository extends UserBaseRepository<Passagier>{
}
