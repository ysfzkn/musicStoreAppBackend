package com.ozkan.musicStore.Controller;

import com.ozkan.musicStore.Model.Instrument;
import com.ozkan.musicStore.Service.InstrumentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("instrument") // prepath
public class InstrumentController
{
    @Autowired
    private InstrumentServiceI instrumentService;

    @PostMapping // instrument POST
    public ResponseEntity<?> saveInstrument(@RequestBody Instrument instrument)
    {
        return new ResponseEntity<>(instrumentService.saveInstrument(instrument), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}") // instrument/{id} DELETE
    public ResponseEntity<?> deleteInstrumentById(@PathVariable Long id)
    {
        instrumentService.deleteInstrument(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping // instrument GET
    public ResponseEntity<?> getAllInstruments()
    {
        return new ResponseEntity<>(instrumentService.findAllInstruments(), HttpStatus.OK);
    }
}
