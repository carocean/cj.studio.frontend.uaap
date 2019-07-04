package cj.studio.frontend.uaap.website;

import org.jsoup.nodes.Document;

import cj.studio.ecm.Scope;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.annotation.CjServiceRef;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView;
import cj.studio.gateway.socket.pipeline.IOutputSelector;

@CjService(name = "/", scope = Scope.multiton)
public class Home implements IGatewayAppSiteWayWebView {
	@CjServiceRef(refByName = "$.output.selector")
	IOutputSelector selector;

	@Override
	public void flow(Frame f, Circuit c, IGatewayAppSiteResource ctx) throws CircuitException {
		Document doc=ctx.html("/index.html");
		c.content().writeBytes(doc.html().getBytes());
	}

}
