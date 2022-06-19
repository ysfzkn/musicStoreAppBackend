package com.ozkan.musicStore.Controller;

import com.ozkan.musicStore.Model.Instrument;
import com.ozkan.musicStore.Service.InstrumentServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("instrument") // prepath
public class InstrumentController
{
    @Autowired
    private InstrumentServiceI instrumentService;
    private byte[] bytes;
    @PostMapping("/upload")
    public void uploadImage(@RequestParam("imageFile") MultipartFile file) throws IOException
    {
        System.out.println(file);
        this.bytes = file.getBytes();
    }
    @PostMapping // instrument POST
    public ResponseEntity<?> saveInstrument(@RequestBody Instrument instrument)
    {
        instrument.setPicByte(this.bytes);
        instrumentService.saveInstrument(instrument);
        this.bytes = null;
        return new ResponseEntity<>(instrument, HttpStatus.CREATED);
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
