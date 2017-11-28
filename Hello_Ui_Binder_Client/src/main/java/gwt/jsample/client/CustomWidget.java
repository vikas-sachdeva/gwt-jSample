package gwt.jsample.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.DivElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseOverEvent;
import com.google.gwt.event.dom.client.MouseOverHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class CustomWidget extends Composite {

	/**
	 * To make widget aware of elements in the template, use the special
	 * “ui:field” attribute in template. Any element that has a field attribute
	 * can be referred directly in java class by defining a @UiField annotated
	 * member variable of a corresponding type.
	 */

	@UiField
	DivElement message;

	@UiField
	Button okButton;

	public CustomWidget() {
		initWidget(binder.createAndBindUi(this));

		// Add DOM event handlers
		okButton.addDomHandler(new MouseOverHandler() {

			@Override
			public void onMouseOver(MouseOverEvent event) {
				okButton.getElement().getStyle().setBackgroundColor("darkgreen");
			}
		}, MouseOverEvent.getType());

		okButton.addDomHandler(new MouseOutHandler() {

			@Override
			public void onMouseOut(MouseOutEvent arg0) {
				okButton.getElement().getStyle().setBackgroundColor("black");
			}
		}, MouseOutEvent.getType());
	}

	/**
	 * To listen for events, use GWT’s shorthand @UiHandler notation. It only
	 * works for widgets that expose that event. Simply annotate any method
	 * (name doesn’t matter) with @UiHandler(“fieldName”) and have it accept the
	 * relevant event as a parameter.
	 * 
	 * The downside with the UiHandler annotation is that it only works with
	 * event’s that the widget normally exposes (such as click events on
	 * buttons). It doesn’t support any of the regular DOM events.
	 * 
	 */
	@UiHandler("okButton")
	void handleClick(ClickEvent e) {
		Window.alert("Thank you!!!");
	}

	public void setMessage(String message) {
		this.message.setInnerText(message);
	}

	/**
	 * This basically creates a class that can render template on demand.
	 */
	private static final Binder binder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, CustomWidget> {
	}
}