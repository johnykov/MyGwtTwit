package pl.janek.lisda.client;

import java.util.Arrays;
import java.util.List;

import pl.janek.lisda.shared.Twit;

import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.CellList;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.view.client.ListDataProvider;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MyGwtListDataProvider implements EntryPoint {
	private TextArea ta = new TextArea();
	// The list of data to display.
	private Button addStockButton = new Button("Add");
	private static final List<String> DAYS = Arrays.asList("Sunday", "Monday",
			"Tuesday", "Wednesday", "Thursday", "Friday", "Saturday");
	// Create a cell to render each value in the list.
	private TextCell textCell = new TextCell();
	// Create a CellList that uses the cell.
	private CellList<String> cellList = new CellList<String>(textCell);

	private TwitServiceAsync twtServ = GWT.create(TwitService.class);

	public void onModuleLoad() {

		// Set the range to display. In this case, our visible range is smaller
		// than
		// the data set.
		// cellList.setVisibleRange(1, 3);

		// Create a data provider.
		final ListDataProvider<String> dataProvider = new ListDataProvider<String>();

		// Connect the list to the data provider.
		dataProvider.addDataDisplay(cellList);

		// Add the data to the data provider, which automatically pushes it to
		// the
		// widget. Our data provider will have seven values, but it will only
		// push
		// the four that are in range to the list.
		List<String> list = dataProvider.getList();
		intialList(dataProvider.getList());
		// Add it to the root panel.

		RootPanel.get().add(ta);
		RootPanel.get().add(addStockButton);
		RootPanel.get().add(cellList);

		// Listen for mouse events on the Add button.
		addStockButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				addStock(dataProvider.getList(), cellList, ta.getText());
			}
		});
	}

	private void intialList(final List<String> list) {
		twtServ.getTwits(new AsyncCallback<List<Twit>>() {

			@Override
			public void onSuccess(List<Twit> result) {
				for (Twit a : result)
					list.add(0, a.getMessage());
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub

			}
		});
	}

	private void addStock(List<String> list, CellList<String> cellList,
			String input) {
		list.add(0, input);
		twtServ.addTwit(new Twit(input), new AsyncCallback<Void>() {

			@Override
			public void onSuccess(Void result) {
				System.out.print("send ok");
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
			}
		});
		cellList.setPageSize(list.size());
	}
}
