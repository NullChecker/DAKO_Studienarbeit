package edu.hm.dako.EchoApplication.UDPMultiThreaded;


import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.PropertyConfigurator;

import edu.hm.dako.EchoApplication.Basics.EchoPDU;

/**
 * Klasse UDPMultiThreadedEchoServer
 * 
 * @author Mandl
 *
 */
public class UDPMultiThreadedEchoServer extends Thread
{	 
		private static Log log = LogFactory.getLog(UDPMultiThreadedEchoServer.class);

		private static int serverPort = 50000;
		
		// Verbindungstabelle: Hier werden alle aktiven Verbindungen zu Clients verwaltet
	    private static Map<String, String> connections = new ConcurrentHashMap<String, String>();
	 
	    // Datagram-Socket des Servers (Listen-Socket)
	    private static UdpSocket serverSocket;    
	
	    private UdpRemoteObject pdu = null;
	    
	    /**
	     * Konstruktor
	     */
		public UDPMultiThreadedEchoServer(UdpRemoteObject receivedPdu)
		{			
			pdu = receivedPdu;
		}

		/**
		 * main
		 * @param args
		 */
   	    public static void main (String args[])
   	    {
   	    	PropertyConfigurator.configureAndWatch("log4j.server.properties", 60 * 1000);
   	    	

        	//TODO UDP-Serversocket registrieren
   	    	
   	    	   	    	
   	    	boolean finished = false;
   	    	EchoPDU receivedPdu;
            
   	    	while (!finished) {

	        	//TODO
	   	   	}
	    
	   	   	// Socket schliessen
	   	   	serverSocket.close();
	    	log.debug("Aktuell angemeldete Clients: " + connections.size());
	    	log.debug("UDPEchoServer beendet sich");    
	      	System.out.println("UDPMultiThreadedEchoServer beendet sich");    
   	    }
   	    
   	  /**
   	     * Worker-Thread-Methode fuer die Bearbeitung eines Clients
   	     */
   	    
   	    public void run()
   	    {	
   	    	EchoPDU echoPdu =(EchoPDU) pdu.getObject();
   	    	setName("WorkerThread-" + echoPdu.getClientName());
   	    	System.out.println(this.getName() + ": WorkerThread uebernimmt Request von " + echoPdu.getClientName());

        	//TODO
   	    	
	 	} // run
 } 