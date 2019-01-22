package com.realdolmen.backend.Domain;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseObject {

    @Version
    private Long versionId;

}
