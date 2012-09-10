package pl.janek.lisda.server;

import java.util.ArrayList;
import java.util.List;

import pl.janek.lisda.shared.Twit;

public class TwitList {
	private List<Twit> ls = new ArrayList<Twit>();

	public TwitList() {
		addToList(new Twit("one"));
		addToList(new Twit("two"));
		addToList(new Twit("thre"));
	}

	public void addToList(Twit in) {
		ls.add(0, in);
	}

	public List<Twit> getTwits() {
		return ls;
	}
}
