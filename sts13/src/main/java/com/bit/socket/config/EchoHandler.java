package com.bit.socket.config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class EchoHandler extends TextWebSocketHandler {
	static Map<String,WebSocketSession> map=new HashMap<String,WebSocketSession>(); 

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("Connected...");
		map.put(session.getId(), session);
	}
	
	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		String msg1=message.getPayload();
		System.out.println(msg1);
		String id=session.getId();
		TextMessage msg2=new TextMessage(id+":"+msg1);
		Set<String> set = map.keySet();
		Iterator<String> ite = set.iterator();
		while(ite.hasNext()) {
			WebSocketSession sess = map.get(ite.next());
			sess.sendMessage(msg2);
		}
	}
	
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("Closed...");
		map.remove(session.getId());
	}
}















