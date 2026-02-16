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
public class FilmCategoryEntityId implements java.io.Serializable {
    private static final long serialVersionUID = 1264291230104627901L;
    @Column(name = "film_id", nullable = false)
    private Short filmId;

    @Column(name = "category_id", nullable = false)
    private Byte categoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FilmCategoryEntityId entity = (FilmCategoryEntityId) o;
        return Objects.equals(this.filmId, entity.filmId) &&
                Objects.equals(this.categoryId, entity.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, categoryId);
    }

}