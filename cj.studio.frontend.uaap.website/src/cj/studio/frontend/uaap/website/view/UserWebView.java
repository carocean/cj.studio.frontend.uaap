package cj.studio.frontend.uaap.website.view;

import cj.studio.backend.uc.bo.User;
import cj.studio.backend.uc.stub.IUserStub;
import cj.studio.ecm.annotation.CjBridge;
import cj.studio.ecm.annotation.CjService;
import cj.studio.ecm.net.Circuit;
import cj.studio.ecm.net.CircuitException;
import cj.studio.ecm.net.Frame;
import cj.studio.gateway.socket.app.IGatewayAppSiteResource;
import cj.studio.gateway.socket.app.IGatewayAppSiteWayWebView;
import cj.studio.gateway.stub.annotation.CjStubRef;

@CjBridge(aspects = "@rest")
@CjService(name = "/user.html")
public class UserWebView implements IGatewayAppSiteWayWebView {

	@CjStubRef(remote = "rest://backend/uc/", stub = IUserStub.class)
	IUserStub userStub;
	@Override
	public void flow(Frame f, Circuit c, IGatewayAppSiteResource ctx) throws CircuitException {
		User user=new User();
		user.setCreatetime(System.currentTimeMillis());
		user.setNickname("bill");
		user.setUsercode("wangq");
		user.setSex(Byte.valueOf("1"));
		user.setRealname("王强");
		user.setPhrase("人生在于玩");
		user.setFace("/img/faces/head4.jpg");
		userStub.saveUser(user);
	}

}
