package org.ospic.inventory.pharmacy.Groups.domains;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import io.swagger.annotations.ApiModel;
import lombok.*;
import org.ospic.inventory.pharmacy.Medicine.domains.Medicine;
import org.ospic.patient.infos.domain.Patient;
import org.ospic.util.constants.DatabaseConstants;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.*;

/**
 * This file was created by eli on 12/11/2020 for org.ospic.inventory.pharmacy.Groups.domains
 * --
 * --
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PUBLIC)
@NoArgsConstructor
@Entity(name = DatabaseConstants.TABLE_MEDICINE_GROUPS_)
@Table(name = DatabaseConstants.TABLE_MEDICINE_GROUPS_,
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name"}),
        })
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MedicineGroup  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private Long id;


    @NotBlank
    @Column(name = "name", length = 20, nullable = false)
    private String name;

    @Column(name = "descriptions", length = 250)
    private String description;

    @OneToMany(
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL,
            orphanRemoval = true

    )
    @JsonIgnore
    @JoinColumn(name = "grp_id")
    private Set<Medicine> medicines = new HashSet<>();

    public MedicineGroup(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MedicineGroup)) return false;
        return id != null && id.equals(((MedicineGroup) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }


}
