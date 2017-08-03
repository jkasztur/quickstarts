package org.narayana.handler;

import com.arjuna.ats.arjuna.coordinator.BasicAction;

import javax.ejb.Singleton;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Singleton
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class MyEJB {

	public void call() {
		System.out.println("MyEJB call");
		final Thread t = new Thread();
		BasicAction.Current().addChildThread(t);
	}
}
