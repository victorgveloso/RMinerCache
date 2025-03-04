/**
 * The contents of this file are subject to the license and copyright
 * detailed in the LICENSE and NOTICE files at the root of the source
 * tree and available online at
 *
 * http://www.dspace.org/license/
 */
package org.dspace.handle;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.dspace.content.DSpaceObject;
import org.dspace.core.Context;

import javax.persistence.*;

/**
 * Database entity representation of the handle table
 *
 * @author kevinvandevelde at atmire.com
 */
@Entity
@Table(name="handle")
public class Handle {

    @Id
    @Column(name="handle_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="handle_seq")
    @SequenceGenerator(name="handle_seq", sequenceName="handle_seq", allocationSize = 1)
    private Integer id;

    @Column(name = "handle", unique = true)
    private String handle;

    @ManyToOne(fetch =  FetchType.EAGER)
    @JoinColumn(name = "resource_id")
    private DSpaceObject dso;

    @Column(name = "resource_type_id")
    private Integer resourceTypeId;

    /**
     * Protected constructor, create object using:
     * {@link org.dspace.handle.service.HandleService#createHandle(Context, DSpaceObject)}
     * or
     * {@link org.dspace.handle.service.HandleService#createHandle(Context, DSpaceObject, String)}
     * or
     * {@link org.dspace.handle.service.HandleService#createHandle(Context, DSpaceObject, String, boolean)}
     *
     */
    protected Handle()
    {

    }

    public Integer getId() {
        return id;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public void setDSpaceObject(DSpaceObject dso) {
        this.dso = dso;
    }

    public DSpaceObject getDSpaceObject() {
        return dso;
    }

    public void setResourceTypeId(Integer resourceTypeId) {
        this.resourceTypeId = resourceTypeId;
    }

    public Integer getResourceTypeId() {
        return resourceTypeId;
    }

    public boolean equals(final Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Handle handle1 = (Handle) o;

        return new EqualsBuilder()
                .append(id, handle1.id)
                .append(handle, handle1.handle)
                .append(resourceTypeId, handle1.resourceTypeId)
                .isEquals();
    }

    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(handle)
                .append(resourceTypeId)
                .toHashCode();
    }
}
