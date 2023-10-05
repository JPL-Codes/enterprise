package com.myplantdiary.enterprise;

import com.myplantdiary.enterprise.dto.Specimen;
import com.myplantdiary.enterprise.service.ISpecimenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlantDiaryController {

    @Autowired
    ISpecimenService specimenService;
    /**
     * Handle the root (/) endpoint and return index page
     * @return
     */
    @RequestMapping("/")
    public String index(Model model){

        Specimen specimen = new Specimen();
        specimen.setDescription("Pawpaw fruit season");
        specimen.setLatitude("38.55");
        specimen.setLongitude("-10.55");
        specimen.setSpeciId("1003");
        specimen.setPlantId(84);

        model.addAttribute(specimen);

        return "start";
    }

    @RequestMapping("/saveSpecimen")
    public String saveSpecimen(Specimen specimen) {
        try {
            specimenService.save(specimen);
        } catch (Exception e) {
            e.printStackTrace();
            return "start";
        }
        return "start";
    }


    /**
     * Endpoint to fetch Specimens
     */
    @GetMapping("/specimen")
    public ResponseEntity fetchAllSpecimens(){
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Endpoint to fetch Specimen by ID
     */
    @GetMapping("/specimen/{id}/")
    public ResponseEntity fetchSpecimenById(@PathVariable("id") String id){
        return new ResponseEntity(HttpStatus.OK);
    }

    /**
     * Endpoint to create Specimen
     */
    @PostMapping(value = "/specimen", consumes = "application/json", produces = "application/json")
    public Specimen createSpecimen(@RequestBody Specimen specimen){
        return specimen;
    }

    /**
     * Endpoint to delete Specimen by ID
     */
    @DeleteMapping("/specimen/{id}")
    public ResponseEntity deleteSpecimen(@PathVariable("id") String id) {
        return new ResponseEntity((HttpStatus.OK));
    }

}