package edu.hm.dako.EchoApplication.Rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.hm.dako.EchoApplication.Basics.AbstractClientThread;
import edu.hm.dako.EchoApplication.Basics.EchoPDU;
import edu.hm.dako.EchoApplication.Basics.SharedClientStatistics;

/**
 * Klasse RMIEchoClientThread
 *  
 * @author Mandl
 *
 */
public class RMIEchoClientThread extends AbstractClientThread
{	 
		private static Log log = LogFactory.getLog(RMIEchoClientThread.class);
				
	    // Name des Threads
	    private String threadName;
	    
	    // Nummer des Echo-Clients
	    private int numberOfClient;
	    
	    // Laenge einer Nachricht
	    private int messageLength;
	    
	    // Anzahl zu sendender Nachrichten je Thread
	    private int numberOfMessages;
	    
	    // Adresse des Servers (String)
	    private String remoteServerAddress;
	    
	    // Well-known Port der RMI Registry, derzeit nicht genutzt, 
	    // da Standard verwendet wird
		private static int RMIRegistryPort = 1099;
	    
	    // RMI-Referenz auf den Server
	    private RMIEchoServerInterface echoServer;
	    
	    // Denkzeit des Clients zwischen zwei Requests in ms
	    private int clientThinkTime;
	    	     
	    // Gemeinsame Daten der Threads
	    private SharedClientStatistics sharedData;
	  
	    // Zeitstempel für RTT-Berechnung
		private long rttStartTime;
		private long rtt;
		
	    /**
	     * initialize
	     * 
	     * @param serverPort: Port des Servers
	     * @param remoteServerAddress: Adresse des Servers
	     * @param numberOfClient: Laufende Nummer des Test-Clients
	     * @param messagelength: Laenge einer Nachricht
	     * @param numberOfMessages: Anzahl zu sendender Nachrichten je Thread
	     * @param clientThinkTime: Denkzeit des Test-Clients
	     * @param sharedData: Gemeinsame Daten der Threads 
	     */
		
		@Override
		public void initialize(
				int serverPort,
				String remoteServerAddress,
				int numberOfClient, 
				int messageLength, 
				int numberOfMessages,
				int clientThinkTime,
				SharedClientStatistics sharedData)
			{		
				this.RMIRegistryPort = serverPort;
			    this.remoteServerAddress = remoteServerAddress;
			    this.numberOfClient = numberOfClient;
			    this.messageLength = messageLength;
			    this.numberOfMessages = numberOfMessages;
			    this.clientThinkTime = clientThinkTime;
			    this.sharedData = sharedData;
				
			    this.setName("RMIEchoClient-".concat(String.valueOf(numberOfClient+1)));    
				threadName = getName();
				

			    //TODO: Lookup
			}
	
		@Override
		public void run() 
		{   
			//TODO
		}	
 }