package org.acme;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Optional;

@Getter
@Setter
@ToString
@Entity
@Table(name = "norm")
@NamedQuery(name = "Norm.findByTitle", query = "select n from Norm n where n.title = :title")
public class Norm extends AbstractEntity
{
    public static final String QUERY_FIND_BY_TITLE = "Norm.findByTitle";

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    public static Optional<Norm> findByTitle(String title)
    {
        return find("#Norm.findByTitle", title).firstResultOptional();
    }
}
