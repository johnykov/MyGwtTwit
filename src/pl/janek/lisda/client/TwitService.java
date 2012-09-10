package pl.janek.lisda.client;

import java.util.List;

import pl.janek.lisda.shared.Twit;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("TwitService")
public interface TwitService extends RemoteService {
	
	void addTwit(Twit inpt);
	List<Twit> getTwits();
}
