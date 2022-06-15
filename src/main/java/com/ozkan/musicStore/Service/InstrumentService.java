package com.ozkan.musicStore.Service;

import com.ozkan.musicStore.Model.Instrument;
import com.ozkan.musicStore.Repository.InstrumentRepositoryI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class InstrumentService implements InstrumentServiceI
{
    private final InstrumentRepositoryI instRepository;

    public InstrumentService(InstrumentRepositoryI instRepository)
    {
        this.instRepository = instRepository;
    }

    @Override
    public Instrument saveInstrument(Instrument instrument)
    {
        instrument.setCreateTime(LocalDateTime.now());
        return instRepository.save(instrument);
    }

    @Override
    public void deleteInstrument(Long id)
    {
        instRepository.deleteById(id);
    }

    @Override
    public List<Instrument> findAllInstruments()
    {
        return instRepository.findAll();
    }

}
