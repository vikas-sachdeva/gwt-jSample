package gwt.jsample.client;

import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface SvgImageBundle extends ClientBundle {

	@Source("sample.svg")
    SVGResource sampleSvg();
	
	public static SvgImageBundle INSTANCE = GWT.create(SvgImageBundle.class);
	
}