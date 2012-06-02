package foo.bar.model;

import org.apache.commons.lang.builder.*;
import javax.persistence.*;

/**
 * This class represents quux objects.
 *
 * @author <a href="mailto:gerjantd@gmail.com">Ger-Jan te Dorsthorst</a>
 */
@Entity
public class Quux extends BaseObject {
	
    private static final long serialVersionUID = 1L;

    private Long id;
    
    private String name;
    
    private String description;

    /**
     * Default constructor - creates a new instance with no values set.
     */
    public Quux() {
    }

    /**
     * Create a new instance and set the name.
     *
     * @param name name of the quux.
     */
    public Quux(final String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    @Column(length = 20)
    public String getName() {
        return this.name;
    }

    @Column(length = 64)
    public String getDescription() {
        return this.description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * {@inheritDoc}
     */
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Quux)) {
            return false;
        }
        final Quux role = (Quux) o;
        return !(name != null ? !name.equals(role.name) : role.name != null);
    }

    /**
     * {@inheritDoc}
     */
    public int hashCode() {
        return (name != null ? name.hashCode() : 0);
    }

    /**
     * {@inheritDoc}
     */
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
                .append(this.name)
                .toString();
    }

    /**
     * {@inheritDoc}
     */
    public int compareTo(Object o) {
        return (equals(o) ? 0 : -1);
    }

}
