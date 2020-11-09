package org.ospic.inventory.admission.service;

import org.ospic.inventory.admission.data.AdmissionRequest;
import org.ospic.inventory.admission.domains.Admission;
import org.ospic.inventory.admission.repository.AdmissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

/**
 * This file was created by eli on 09/11/2020 for org.ospic.inventory.admission.service
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
@Repository
public class AdmissionsWriteServiceImpl implements AdmissionsWriteService {

    @Autowired
    AdmissionRepository admissionRepository;

    public AdmissionsWriteServiceImpl(AdmissionRepository admissionRepository) {
        this.admissionRepository = admissionRepository;
    }

    @Override
    public ResponseEntity<String> admitPatient(AdmissionRequest admissionRequest) {
        Admission admission = new Admission().addFromRequest(admissionRequest);
        admissionRepository.save(admission);
        return ResponseEntity.ok().body("Patient Admitted successfully");
    }

    @Override
    public ResponseEntity<String> endPatientAdmission() {
        return null;
    }

    @Override
    public ResponseEntity<String> updatePatientAdmissionInfo() {
        return null;
    }
}
