package com.anibal.educational.rest_service.comps.cache;

import java.util.List;

import com.anibal.educational.rest_service.comps.util.RestServiceUtil;
import com.anibal.educational.rest_service.domain.TicketLineState;
import com.odhoman.api.utilities.cache.AbstractCacheManager;

public class LineStateCacheManager extends AbstractCacheManager<TicketLineState, String>{

	private static final LineStateCacheManager INSTANCE = new LineStateCacheManager();
	
	private LineStateCacheManager() {
		super(RestServiceUtil.getConfig());
	}
	
	public static LineStateCacheManager getInstance() {
		return INSTANCE;
	}

	@Override
	protected String geKeyForMap(TicketLineState item) {
		return item.getLineStateTitle();
	}

	@Override
	protected boolean match(TicketLineState item, String filter) {
		return item.getLineStateTitle()!=null && item.getLineStateTitle().equals(filter);
	}

	@Override
	protected List<TicketLineState> sortItems(List<TicketLineState> items) {
		return items;
	}

}
