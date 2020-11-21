package org.ospic.inventory.admission.repository;

import org.ospic.inventory.admission.domains.Admission;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * This file was created by eli on 09/11/2020 for org.ospic.inventory.admission.repository
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
public interface AdmissionRepository extends JpaRepository<Admission,Long> {
    boolean isActive(Long admissionId);
    boolean existsByBedsId(Long bedId);
    boolean existsByPatientId(Long patientId);
    Optional<Admission> findById(Long admissionId);
    List<Admission> findByPatientId(Long patientId);
    List<Admission> findByBedsId(Long bedId);

}
