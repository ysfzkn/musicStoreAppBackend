package com.ozkan.musicStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

@SpringBootApplication
public class MusicStoreApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(MusicStoreApplication.class, args);
	}



}
