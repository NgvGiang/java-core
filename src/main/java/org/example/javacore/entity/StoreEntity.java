package org.example.javacore.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "store")
public class StoreEntity {
    @Id
    @Column(name = "store_id", nullable = false)
    private Byte id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "manager_staff_id", nullable = false)
    private StaffEntity managerStaff;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "address_id", nullable = false)
    private AddressEntity address;

    @Column(name = "last_update", nullable = false)
    private Instant lastUpdate;

    @OneToMany(mappedBy = "store")
    private Set<CustomerEntity> customers = new LinkedHashSet<>();

    @OneToMany(mappedBy = "store")
    private Set<InventoryEntity> inventories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "store")
    private Set<StaffEntity> staff = new LinkedHashSet<>();

}