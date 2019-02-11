package com.realdolmen.backend.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;

@MappedSuperclass
public abstract class BaseObject implements Serializable {

    @Version
    @Setter
    @Getter
    private Long versionId;

}
