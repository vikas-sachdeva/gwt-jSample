package gwt.jsample.button;

import org.vectomatic.dom.svg.ui.SVGResource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;

public interface SvgImageBundle extends ClientBundle {

	@Source("add.svg")
	SVGResource add();
	
	@Source("delete.svg")
	SVGResource delete();

	public static SvgImageBundle INSTANCE = GWT.create(SvgImageBundle.class);
}
