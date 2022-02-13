package br.com.casadocodigo.loja.websockets;

import java.io.IOException;

import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/canal/promos")
public class PromosEndpoint {

	@OnOpen
	public void onMessage(Session session) {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(session.isOpen()) {
			try {
				session.getBasicRemote()
					.sendText("{'titulo':'Livro JavaOO com 40% de desconto', 'livroId':35}");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
