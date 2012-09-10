package pl.janek.lisda.server;

import java.util.List;

import pl.janek.lisda.client.TwitService;
import pl.janek.lisda.shared.Twit;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class TwitServiceImpl extends RemoteServiceServlet implements
		TwitService {
	private TwitList tl = new TwitList();
	private static final long serialVersionUID = 6295267835491452652L;

	@Override
	public void addTwit(Twit inpt) {
		tl.addToList(inpt);
	}

	@Override
	public List<Twit> getTwits() {
		return tl.getTwits();
	
	}
}
