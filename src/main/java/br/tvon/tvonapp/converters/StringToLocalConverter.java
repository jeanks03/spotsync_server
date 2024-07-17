package br.tvon.tvonapp.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.tvon.tvonapp.service.LocalService;
import br.tvon.tvonapp.spotsync.entities.Local;

@Component
public class StringToLocalConverter implements Converter<String, Local> {
	
	@Autowired
	private LocalService service;

	@Override
	public Local convert(String source) {
		int id = Integer.valueOf(source);
		return service.procuraPorId(id);
	}

}
