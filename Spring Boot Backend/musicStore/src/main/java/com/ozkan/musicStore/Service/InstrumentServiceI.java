package com.ozkan.musicStore.Service;


import com.ozkan.musicStore.Model.Instrument;

import java.util.List;

public interface InstrumentServiceI
{

    Instrument saveInstrument(Instrument instrument);

    void deleteInstrument(Long id);

    List<Instrument> findAllInstruments();
}
