package gwt.jsample.button;

import org.vectomatic.dom.svg.ui.SVGImage;
import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;

public class SvgImageButtonWidget extends Composite {

	private FlowPanel panel;

	private SVGResource svgResource;

	public SvgImageButtonWidget(SVGResource svgResource) {
		this.svgResource = svgResource;
		panel = new FlowPanel();
		renderImage();
		initWidget(panel);
	}

	private void renderImage() {
		panel.clear();
		SVGImage image = new SVGImage(svgResource);
		panel.add(image);
		panel.addStyleName("button");
	}

	public void registerClickHandler(ClickHandler clickHandler) {
		panel.addDomHandler(clickHandler, ClickEvent.getType());
	}
}