package edu.hm.dako.EchoApplication.TCPMultiThreaded;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Calendar;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.hm.dako.EchoApplication.Basics.AbstractClientThread;
import edu.hm.dako.EchoApplication.Basics.EchoPDU;
import edu.hm.dako.EchoApplication.Basics.SharedClientStatistics;


/**
 * Klasse TCPMultiThreadedEchoClientThread
 *  
 * @author Mandl
 *
 */
public class TCPMultiThreadedEchoClientThread extends AbstractClientThread
{	 
		private static Log log = LogFactory.getLog(TCPMultiThreadedEchoClientThread.class);
				
	    // Lokaler Port zur Kommunikation mit dem Echo-Server 
	    private int currentPort;
	    		
	    // Name des Threads
	    private String threadName;
	    
	    // Nummer des Echo-Clients
	    private int numberOfClient;
	    
	    // Laenge einer Nachricht
	    private int messageLength;
	    
	    // Anzahl zu sendender Nachrichten je Client-Thread
	    private int numberOfMessages;
	  
	    // Portnummer des Threads
	    private int localPort;
	    
	    // Serverport 
	    private int serverPort;
	    
	    // Adresse des Servers
	    private String remoteServerAddress;
	    
	    // Denkzeit des Clients zwischen zwei Requests in ms
	    private int clientThinkTime;
	    
	    // Gemeinsame Daten der Threads
	    private SharedClientStatistics sharedData;
	    
	    // Socket-Verbindung
	    private Socket con;
	    private ObjectInputStream in;
	    private ObjectOutputStream out;
	  
	    // Zeitstempel für RTT-Berechnung und Kalender
		private long rttStartTime;
		private long rtt;
		private Calendar cal;
		
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
		    this.serverPort = serverPort;
		    this.remoteServerAddress = remoteServerAddress;
		    this.numberOfClient = numberOfClient;
		    this.messageLength = messageLength;
		    this.numberOfMessages = numberOfMessages;
		    this.clientThinkTime = clientThinkTime;
		    this.sharedData = sharedData;
			this.setName("EchoClient-".concat(String.valueOf(numberOfClient+1)));    
			threadName = getName();
		    
			// Verbindung zum Server aufbauen
			try { 
			      con = new Socket(remoteServerAddress, serverPort);
			      out = new ObjectOutputStream(con.getOutputStream());
			      in = new ObjectInputStream(con.getInputStream());
			      localPort = con.getLocalPort();
			      log.debug(threadName + ": Verbindung zum Server aufgebaut mit Port " + localPort);
				  log.debug(threadName + ": Registrierter Port: " + currentPort);    	
	        } 
		    catch (Exception e) 
	        {               
	            log.debug("Exception beim Verbindungsaufbau: " + e);
	        }
		}

		/**
		 * Run-Methode fuer den Test-Thread: 
		 * Client-Thread sendet hier alle Requests und wartet auf Antworten
		 */
		public void run() 
		{   
			sharedData.incrNumberOfLoggedInClients();
			  
	        /**
	         * Synchronisation mit allen anderen Client-Threads:
	         * Warten, bis alle Clients angemeldet sind und dann
	         * erst mit der Lasterzeugung beginnen
	         */
	        while (!sharedData.allClientsLoggedIn())
	       	{
	        	try {     
			        Thread.sleep(100);
	        	}
		        catch (InterruptedException e) {
		        	log.error("Sleep unterbrochen");
		        }
	        }
	        
			// TODO
		}	
 }