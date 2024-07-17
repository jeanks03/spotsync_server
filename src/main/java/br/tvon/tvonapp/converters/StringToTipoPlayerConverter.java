package br.tvon.tvonapp.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.tvon.tvonapp.service.TipoPlayerService;
import br.tvon.tvonapp.spotsync.entities.TipoPlayer;

@Component
public class StringToTipoPlayerConverter implements Converter<String, TipoPlayer> {
	
	@Autowired
	private TipoPlayerService service;

	@Override
	public TipoPlayer convert(String source) {
		int id = Integer.valueOf(source);
		return service.procuraPorId(id);
	}

}
