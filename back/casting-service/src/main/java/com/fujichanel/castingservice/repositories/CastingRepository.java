package com.fujichanel.castingservice.repositories;

import com.fujichanel.castingservice.entities.Casting;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CastingRepository extends MongoRepository<Casting, String> {
}
