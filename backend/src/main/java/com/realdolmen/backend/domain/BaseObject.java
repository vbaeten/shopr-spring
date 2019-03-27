package com.realdolmen.backend.domain;

import lombok.*;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
@NoArgsConstructor
@Builder(builderClassName = "BaseObjectBuilder")
@AllArgsConstructor
public class BaseObject implements Serializable {

    @Version
    @Setter
    @Getter
    private Long versionId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseObject)) return false;
        BaseObject that = (BaseObject) o;
        return Objects.equals(versionId, that.versionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(versionId);
    }
}
