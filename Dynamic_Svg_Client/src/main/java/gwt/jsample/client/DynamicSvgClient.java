package gwt.jsample.client;

import org.vectomatic.dom.svg.OMSVGCircleElement;
import org.vectomatic.dom.svg.OMSVGDocument;
import org.vectomatic.dom.svg.OMSVGLength;
import org.vectomatic.dom.svg.OMSVGSVGElement;
import org.vectomatic.dom.svg.utils.OMSVGParser;
import org.vectomatic.dom.svg.utils.SVGConstants;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class DynamicSvgClient implements EntryPoint {

	@Override
	public void onModuleLoad() {
		OMSVGDocument document = OMSVGParser.currentDocument();

		OMSVGSVGElement svgElement = document.createSVGSVGElement();

		svgElement.setWidth(OMSVGLength.SVG_LENGTHTYPE_PX, 400);
		svgElement.setHeight(OMSVGLength.SVG_LENGTHTYPE_PX, 400);

		OMSVGCircleElement circle1 = document.createSVGCircleElement(150, 150, 10);
		circle1.getStyle().setSVGProperty(SVGConstants.CSS_FILL_PROPERTY, "blue");
		svgElement.appendChild(circle1);

		OMSVGCircleElement circle2 = document.createSVGCircleElement(175, 150, 10);
		circle2.getStyle().setSVGProperty(SVGConstants.CSS_FILL_PROPERTY, "red");
		svgElement.appendChild(circle2);

		OMSVGCircleElement circle3 = document.createSVGCircleElement(200, 150, 10);
		circle3.getStyle().setSVGProperty(SVGConstants.CSS_FILL_PROPERTY, "yellow");
		svgElement.appendChild(circle3);

		OMSVGCircleElement circle4 = document.createSVGCircleElement(225, 150, 10);
		circle4.getStyle().setSVGProperty(SVGConstants.CSS_FILL_PROPERTY, "green");
		svgElement.appendChild(circle4);

		OMSVGCircleElement circle5 = document.createSVGCircleElement(175, 180, 10);
		circle5.getStyle().setSVGProperty(SVGConstants.CSS_FILL_PROPERTY, "green");
		svgElement.appendChild(circle5);

		OMSVGCircleElement circle6 = document.createSVGCircleElement(200, 180, 10);
		circle6.getStyle().setSVGProperty(SVGConstants.CSS_FILL_PROPERTY, "blue");
		svgElement.appendChild(circle6);

		RootPanel.get("gwtContainer").getElement().appendChild(svgElement.getElement());
	}
}
