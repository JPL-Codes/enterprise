
package com.myplantdiary.enterprise.service;

import com.myplantdiary.enterprise.dao.ISpecimenDAO;
import com.myplantdiary.enterprise.dto.Specimen;
import org.springframework.stereotype.Component;

@Component
public class SpecimenServiceStub implements ISpecimenService {

    private ISpecimenDAO specimenDAO;

    public SpecimenServiceStub() {

    }

    public SpecimenServiceStub(ISpecimenDAO specimenDAO) {
        this.specimenDAO = specimenDAO;
    }

    public Specimen save(Specimen specimen) {
        return specimenDAO.save(specimen);
    }
}