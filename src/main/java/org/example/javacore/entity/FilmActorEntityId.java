package org.example.javacore.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Getter
@Setter
@Embeddable
public class FilmActorEntityId implements java.io.Serializable {
    private static final long serialVersionUID = -7078657803450732502L;
    @Column(name = "actor_id", nullable = false)
    private Short actorId;

    @Column(name = "film_id", nullable = false)
    private Short filmId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmActorEntityId entity = (FilmActorEntityId) o;
        return Objects.equals(this.actorId, entity.actorId) &&
                Objects.equals(this.filmId, entity.filmId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(actorId, filmId);
    }

}