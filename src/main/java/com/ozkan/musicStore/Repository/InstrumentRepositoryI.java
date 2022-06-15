package com.ozkan.musicStore.Repository;


import com.ozkan.musicStore.Model.Instrument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstrumentRepositoryI extends JpaRepository<Instrument, Long>
{
    // Default operations
}
