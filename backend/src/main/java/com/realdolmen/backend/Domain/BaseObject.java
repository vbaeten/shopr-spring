package com.realdolmen.backend.Domain;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ObjectId;

    @Version
    private Long versionId;


}
