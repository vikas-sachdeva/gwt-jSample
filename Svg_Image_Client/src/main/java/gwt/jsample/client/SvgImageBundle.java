package gwt.jsample.client;

import org.vectomatic.dom.svg.ui.ExternalSVGResource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface SvgImageBundle extends ClientBundle {

	@Source("sample.svg")
    ExternalSVGResource sample();
	
	public static SvgImageBundle INSTANCE = GWT.create(SvgImageBundle.class);
	
}