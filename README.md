vanilla-appfuse-2.1.0-spring-mvc
================================

Vanilla Appfuse 2.1.0 project (Spring MVC + Hibernate), including full-source, templates and eclipse project files

mvn archetype:generate -B -DarchetypeGroupId=org.appfuse.archetypes -DarchetypeArtifactId=appfuse-basic-spring-archetype -DarchetypeVersion=2.1.0 -DgroupId=foo.bar -DartifactId=baz -DarchetypeRepository=http://oss.sonatype.org/content/repositories/appfuse

# use maven 2.2.1 not 3.0.4 for full-source
cd baz
/opt/apache-maven-2.2.1/bin/mvn appfuse:full-source

mvn appfuse:copy-templates
cd src/test/resources/appfuse/model/
sed -i -e "s/generateJoinColumnsAnnotation(property/generateJoinColumnsAnnotation(property,cfg/" Ejb3PropertyGetAnnotation.ftl 
cd ../../../../..

mvn org.apache.maven.plugins:maven-eclipse-plugin:2.6:eclipse

vi src/main/java/foo/bar/model/Quux.java
# insert
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
# end insert
