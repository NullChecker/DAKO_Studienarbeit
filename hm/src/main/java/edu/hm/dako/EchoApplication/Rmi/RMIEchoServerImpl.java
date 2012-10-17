package edu.hm.dako.EchoApplication.Rmi;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.hm.dako.EchoApplication.Basics.EchoPDU;
	
/**
 * Klasse RMIEchoServerImpl
 * @author Mandl
 */
 public class RMIEchoServerImpl extends UnicastRemoteObject implements RMIEchoServerInterface 
{	 
	private static final long serialVersionUID = 99L;
	private static Log log = LogFactory.getLog(RMIEchoServerImpl.class);
		
	// Verbindungstabelle: Hier werden alle aktiven Verbindungen zu Clients verwaltet
	private static Map<String, String> connections = new ConcurrentHashMap<String, String>();
	 
	/**
	 * Echo-Methode
	 */
	public RMIEchoServerImpl() throws RemoteException 
	{	
	}

	/**
	 * Echo-Methode
	 */
	public EchoPDU echo(EchoPDU message) throws RemoteException 
	{	
   	    long startTime;
   	    EchoPDU sendPdu=null;	    	
			

		//TODO
	   	 return sendPdu;  
	}
}