package pl.janek.lisda.client;

import java.util.List;

import pl.janek.lisda.shared.Twit;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface TwitServiceAsync {

	void addTwit(Twit inpt, AsyncCallback<Void> callback);

	void getTwits(AsyncCallback<List<Twit>> callback);

}
